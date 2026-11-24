# Advanced Tabs Android App (Java + XML)

This project implements the Al-Aqsa University exam requirements shown in the supplied screenshots.

## Features
- MainActivity login screen with Email and Password fields.
- TextWatcher validation: valid email address and password length of at least 6 characters.
- Login button stays disabled until both fields are valid.
- Login opens ModeActivity.
- ModeActivity contains TabLayout + ViewPager2 with First, Second, and Third tabs.
- Tabs support swipe navigation.
- Back from Second/Third returns to First; back from First returns to MainActivity.
- MainActivity shows `Press back again to exit` on the first back press and exits on a second press within 2 seconds.
- PopupMenu offers Light, Night, and System themes.
- Toolbar Up button returns directly to MainActivity.

## Open in Android Studio
1. Extract the ZIP file.
2. In Android Studio choose **Open** and select the `AdvancedTabsAndroid` folder.
3. Allow Gradle Sync to finish. Use JDK 17.
4. Install Android SDK Platform 35 if Android Studio requests it.
5. Run the app on an emulator or Android device.

## Notes
- Login validation is client-side only. No backend or real account authentication was requested in the exam instructions.
- The project uses Android Gradle Plugin 8.6.1 and Gradle 8.7.
- If your Android Studio version suggests a compatible Gradle/AGP upgrade, use its recommended upgrade path.

## Demo video checklist (maximum 3 minutes)
1. Introduce yourself with your full name and student ID.
2. Show invalid email and short password; confirm Login remains disabled.
3. Enter a valid email and a password with 6+ characters; show Login enabled.
4. Log in, swipe First → Second → Third.
5. Press Back on Third and show return to First.
6. Press Back on First and show MainActivity.
7. Press Back once to show the Snackbar, then press again to exit.
8. Reopen, show Set Mode → Light, Night, and System.
9. Show the Up button returning to MainActivity.

## GitHub submission
Create a **public** GitHub repository and push the extracted project folder. Submit the repository URL in the Moodle answer field using the required format:
`StudentName_ID_Exam2`
