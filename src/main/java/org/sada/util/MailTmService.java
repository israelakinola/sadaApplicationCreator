package org.sada.util;

import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.regex.*;
import org.json.*;

public class MailTmService {

    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    // ============================
    // CREATE INBOX (FIXED)
    // ============================
    public String createInbox(String password) {

        try {
            String domain = getValidDomain();

            String email = "test" + System.currentTimeMillis() + "@" + domain;

            String body = """
            {
              "address": "%s",
              "password": "%s"
            }
            """.formatted(email, password);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.mail.tm/accounts"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Create inbox response: " + response.body());

            if (response.statusCode() != 201) {
                throw new RuntimeException("Failed to create inbox: " + response.body());
            }

            System.out.println("Created email: " + email);
            return email;

        } catch (Exception e) {
            throw new RuntimeException("Error creating Mail.tm inbox", e);
        }
    }

    // ============================
    // GET VALID DOMAIN (CRITICAL)
    // ============================
    private String getValidDomain() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.mail.tm/domains"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject obj = new JSONObject(response.body());
        JSONArray domains = obj.getJSONArray("hydra:member");

        if (domains.length() == 0) {
            throw new RuntimeException("No valid Mail.tm domains available");
        }

        String domain = domains.getJSONObject(0).getString("domain");

        System.out.println("Using domain: " + domain);

        return domain;
    }

    // ============================
    // MAIN ENTRY (OTP)
    // ============================
    public String getOtp(String email, String password) {

        try {
            String token = authenticate(email, password);
            String messageId = waitForMessage(token);
            return fetchOtp(token, messageId);

        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve OTP for: " + email, e);
        }
    }

    // ============================
    // AUTHENTICATE
    // ============================
    private String authenticate(String email, String password) throws Exception {

        String body = """
        {
          "address": "%s",
          "password": "%s"
        }
        """.formatted(email, password);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.mail.tm/token"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());



        JSONObject obj = new JSONObject(response.body());

        if (!obj.has("token")) {
            throw new RuntimeException("Authentication failed: " + obj.toString());
        }

        return obj.getString("token");
    }

    // ============================
    // WAIT FOR EMAIL
    // ============================
    private String waitForMessage(String token) throws Exception {

        HttpRequest inboxRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.mail.tm/messages"))
                .header("Authorization", "Bearer " + token)
                .build();

        for (int i = 0; i < 30; i++) {

            HttpResponse<String> response =
                    client.send(inboxRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject inbox = new JSONObject(response.body());
            JSONArray messages = inbox.getJSONArray("hydra:member");

            if (messages.length() > 0) {
                String messageId = messages.getJSONObject(0).getString("id");

                return messageId;
            }

            Thread.sleep(2000);
        }

        throw new RuntimeException("No email received within timeout");
    }

    // ============================
    // EXTRACT OTP
    // ============================
    private String fetchOtp(String token, String messageId) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.mail.tm/messages/" + messageId))
                .header("Authorization", "Bearer " + token)
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        String text = new JSONObject(response.body()).getString("text");


        Pattern pattern = Pattern.compile("\\b\\d{4,8}\\b");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String otp = matcher.group();
            System.out.println("Extracted OTP: " + otp);
            return otp;
        }

        throw new RuntimeException("OTP not found in email");
    }
}