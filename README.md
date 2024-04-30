# Lean Innovation Lab Spring 2024 | Carnegie Mellon University

Welcome to the repository for the USAF-507 project MVP.

## Emergency Reporting App

### Overview
The Emergency Reporting App aims to streamline the process of generating emergency reports, reducing time consumption and minimizing errors. Developed as an Android application prototype, this MVP focuses on creating SALUTE, MEDEVAC, and Standard 9-Line UXO Reports, essential for security forces and radio telephone operators.

### Features
- User-friendly interface for easy navigation and data input
- Pre-defined values for selection in certain fields
- Manual entry option for fields requiring user input
- Ability to review and submit reports within the application
- Access to previous reports for reference and editing

## Running and Testing the Code
This is the repo for the USAF-507 Project MVP. 
To run, modify, or test the code:

1. Download and install [Android Studio](https://developer.android.com/studio).
2. Clone the repository and open the entire directory in Android Studio.
3. Navigate to `app/src/main/java/com.example.lil`.
4. You can now run `MainActivity.java` to observe the app's behavior or modify other Java files.
5. UI/layout files are located in `app/src/main/res`.

## Installation on Device

To install the app on a device:

1. Navigate to `LIL/APP/release` and download `USAF507_MVP.apk`.
2. Enable installation from unknown sources in your device settings.
3. Install the application by opening the APK file and following the on-screen instructions.

## Usage
1. Launch the application on your Android device.
2. Navigate through the available reports (SALUTE, MEDEVAC, Standard 9-Line UXO).
3. Fill out the required fields by selecting pre-defined values or manually entering information.
4. Review the completed report for accuracy.
5. Submit the report using the designated submission method.
6. Access previous reports for reference or editing as needed.

## Developer Notes
- The night mode button can make the app present content on a black background with red text for low-light scenarios.
- Fill in the reports following the prompt, the report will be saved once the user presses the submit button on the last page of each report. 
- Saved reports can be accessed using the menu's view existing report(s) button.

*Note: this is a proof of concept prototype that does not have proven operational functionality to transmit data to another device, or authenticate any user.*
