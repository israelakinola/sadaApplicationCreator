# SADA Application Creator

This script creates a SADA application through the UI using the Chrome browser.  
It is built using the **Page Object Model (POM)** design pattern.

All pages (elements and actions) that make up the SADA application are located in the `/pages` folder.

Application types (e.g., Single, Married, etc.) are defined in the `/applications` directory.

---

## 📁 Project Structure
/pages # Page objects (elements and actions)
/applications # Application type definitions
ApplicantInfo.java
main.java


## 🚀 How to Run

1. Open `ApplicantInfo.java`.
2. Fill in the applicant information details:
   - **ENV section**
   - **Personal Information section** (most important)
3. Run `main.java`.
4. Follow the instructions displayed in the terminal.

⚙️ Prerequisites
- Make sure the following are installed and configured:
- Java (Java 17+ recommended)
- Maven
- Chrome browser
- ChromeDriver (comes with Maven Selenium aleady) 
- IntelliJ IDEA (Community Edition) (recommended)

## 📝 Notes
- Have Java Insatlled
- The project build tool is Maven, Hve Inteli J IDE (Free version) is highly recommended for usage
- Ensure Chrome browser is installed and properly configured.
- Double-check all required fields in `ApplicantInfo.java` before execution.
