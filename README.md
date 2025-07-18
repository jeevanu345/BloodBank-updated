# BloodBank - Android Application

*Connecting Donors, Saving Lives.*

[![Platform](https://img.shields.io/badge/platform-Android-green.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![made-with-kotlin](https://img.shields.io/badge/Made%20with-Kotlin-172023.svg?logo=kotlin)](https://kotlinlang.org/)

BloodBank is a modern Android application designed to connect blood donors with recipients in real-time. This app aims to bridge the critical gap between the demand and supply of blood, making it easier for people to find and donate blood during emergencies.

## Core Mission

This project was born from a simple idea: to use technology to bridge a critical gap in our healthcare system. The primary goal is to create a seamless and efficient platform that empowers communities to save lives. By leveraging mobile technology, we can quickly alert and mobilize voluntary blood donors, reducing the time and effort required to find a life-saving match.

---

## Features

* **Engaging Welcome Screen:** A smooth, animated entry point to welcome the user.
* **Secure User Registration:** Easy sign-up and login for both donors and recipients using Firebase Authentication.
* **Donor & Recipient Profiles:** Users can create and manage their profiles with details like blood group, contact information, and availability.
* **Find Donors:** Search for available blood donors based on **Blood Group** and **Location** (City/PIN code).
* **Post Blood Requests:** Recipients or their relatives can post urgent blood requests, which are instantly visible to relevant donors.
* **Real-time Notifications:** Donors receive push notifications via Firebase Cloud Messaging when a new blood request matching their profile is posted nearby.
* **Interactive Map View:** Visualize nearby donors and blood banks on Google Maps.
* **Privacy Focused:** User data is handled with care, and contact details are only shared upon user consent.

---

## Screenshots

| Welcome Screen | Login Screen | Home Dashboard |
| :----------: | :---------: | :--------------: |
| ![Welcome](https://via.placeholder.com/250x500.png?text=BloodBank+Welcome) | ![Login](https://via.placeholder.com/250x500.png?text=Login+Screen) | ![Home](https://via.placeholder.com/250x500.png?text=Home+Dashboard) |

| Donor Search | Donor Profile | Map View |
| :--------------: | :-----------: | :------: |
| ![Search](https://via.placeholder.com/250x500.png?text=Donor+Search) | ![Profile](https://via.placeholder.com/250x500.png?text=Donor+Profile) | ![Map](https://via.placeholder.com/250x500.png?text=Map+View) |


---

## Tech Stack & Architecture

This project is built using modern Android development tools and follows the recommended architecture patterns.

* **Language:** [Kotlin](https://kotlinlang.org/)
* **Architecture:** MVVM (Model-View-ViewModel)
* **UI:**
    * XML with Material Design Components.
    * Android Animation Framework (`AnimationUtils`) for engaging UI transitions.
* **Asynchronous Programming:** Kotlin Coroutines & Flow
* **Dependency Injection:** Hilt
* **Networking:** [Retrofit](https://square.github.io/retrofit/) & [OkHttp](https://square.github.io/okhttp/) for API calls.
* **Backend & Database:**
    * [Firebase Firestore](https://firebase.google.com/docs/firestore) for live data.
    * [Firebase Authentication](https://firebase.google.com/docs/auth) for user management.
    * [Firebase Cloud Messaging (FCM)](https://firebase.google.com/docs/cloud-messaging) for push notifications.
* **Android Jetpack Components:**
    * ViewModel
    * LiveData & StateFlow
    * Navigation Component
    * Room (for local data caching)

---

## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

* Android Studio Iguana | 2023.2.1 or later.
* JDK 17 or later.
* An Android device or emulator with API level 21 or higher.

### Installation & Setup

1.  **Clone the repository**
    ```sh
    git clone [https://github.com/jeevanu345/BloodBank-updated.git](https://github.com/jeevanu345/BloodBank-updated.git)
    ```

2.  **Firebase Setup**
    * Go to the [Firebase Console](https://console.firebase.google.com/) and create a new project.
    * Add an Android app to your Firebase project with the exact package name: `com.example.bloodbank2`.
    * Download the generated `google-services.json` file and place it in the `app/` directory of your project.
    * In the Firebase Console, enable **Authentication** (e.g., Email/Password method) and **Firestore Database**.

3.  **Google Maps API Key**
    * Go to the [Google Cloud Console](https://console.cloud.google.com/).
    * Enable the "Maps SDK for Android".
    * Generate an API key and add it to your `local.properties` file:
        ```properties
        MAPS_API_KEY="YOUR_API_KEY_HERE"
        ```

4.  **Open in Android Studio**
    * Open Android Studio and select `Open`.
    * Navigate to the cloned repository directory and click OK.
    * Let Android Studio sync the project with Gradle.

5.  **Build and Run**
    * Click the `Run 'app'` button or press `Shift + F10`.

---

## How to Contribute

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".

1.  **Fork** the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a **Pull Request**

---

## License

Distributed under the MIT License. See `LICENSE` for more information.

---

## Contact

Created by **Jeevan U Gowda** - jeevanu345@gmail.com

Project Link: [https://github.com/jeevanu345/BloodBank-updated](https://github.com/jeevanu345/BloodBank-updated)
