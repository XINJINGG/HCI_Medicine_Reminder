# Medication Reminder Android App

This is a Medication Reminder Android application designed to assist elderly users with managing their medications. The app features consumption reminders, refill tracking, and a reward system to motivate timely and consistent medication intake. It has two interfaces—one for elderly users and one for guardians, with functionalities such as adding/editing medication details, tracking progress, and notifications.

## Features
- **Medication**: Display a list of medications with details.
- **Alarms**: Set alarms for each medication to remind elderly to eat their medication
- **Medication Details**: View detailed information about a selected medication.
- **Add/Edit Medications**: Add new medications or edit existing ones.
- **Achievement System**: Helps to track and motivate users with streaks and achievements to show off to their peers
  
---

## Requirements

- **Android Studio** (Latest version recommended)
- **Android SDK** (API Level 21 or higher)
- **Java** (JDK 8 or higher)
- **Gradle** (Configured automatically by Android Studio)

---

## Setting Up the Project

### 1. Clone the Repository

First, clone the repository to your local machine using the following command:

```bash
git clone https://github.com/XINJINGG/HCI_Medicine_Reminder.git
```

Alternatively, you can download the ZIP file from the repository page and extract it.

### 2. Open the Project in Android Studio

- Launch **Android Studio**.
- Click on **File** > **Open**.
- Navigate to the folder where you cloned the project and select it.
- Wait for Android Studio to sync and index the project.

### 3. Install Dependencies

Ensure that all the required dependencies are installed and synced in the project. Android Studio will automatically detect and download them through Gradle.

If you encounter issues, you can manually sync the project with Gradle:

- Click on **File** > **Sync Project with Gradle Files**.

### 4. Set Up an Emulator or Device

You can run the app on an emulator or a physical Android device.

- For **Emulator**:
  1. Go to **Tools** > **AVD Manager** in Android Studio.
  2. Look for **Andriod 14.0("UpsideDownCake") API Level 34**, then press OK
  3. Go to **Tools** > **Device Manager** in Android Studio.
  4. Create a new virtual device by clicking on the + icon, and create a new device
  5. Scroll down and find **Pixel 3a**, and click Next
  6. Click on **Other Images** and look for **Andriod 14.0("UpsideDownCake") API Level 34**
  7. <img width="558" alt="image" src="https://github.com/user-attachments/assets/9e085f8a-f201-424d-9edd-870d40b5803d">
      
      Double check with the image to make sure the emulator set up is the same
  8. <img width="342" alt="image" src="https://github.com/user-attachments/assets/6dab55c7-9449-46db-951c-b941132073c0">
      
      Select the correct newly created emulator
  9. Start the project.
  
- For **Physical Device (wifi)**:
  1. Enable **Developer Options** on your Android device.
  2. Turn on **Wireless Debugging**.
  3. Click on **Pair device with QR code and scan the QR Code**
  4. Make sure your device and your computer is connected on the **same wifi network**
        - If the connection is taking too long, try using mobile hotspot as school wi-fi might not work
  5. <img width="346" alt="image" src="https://github.com/user-attachments/assets/875fec61-6576-41f3-ae4b-a45fc205f46e">

    Select your device in Android Studio.

  6. Run the application.

### 5. Build and Run the App

- Click on the **Run** button (green triangle) or press **Shift + F10**.
- Android Studio will build the project and deploy it to your emulator or device.

---

## Navigating around the App

1. **Medication List**: The medication page displays a list of medications. Tap on any item to view its details.
2. **Alarms**: The alarm page shows and allows user to add and view their alarms
3. **Home**: The home page display all upcoming mediction for the day as well as the missed medication for the day
4. **Rewards**: The rewards page shows them how consistently users have taken their medication for as well as badges they can earn
5. **Profile**: The profile page displays the user's information

---
