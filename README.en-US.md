<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</div>

---

# Mini-Pokedex (Native Android with Kotlin)

A simple Pokedex app for Android, built with Kotlin, as the final project for the Venturus Native Android course. It features list/detail screens, search/filter functionality, and consumes the public PokéAPI.

This project is being developed following market best practices, including a workflow based on Sprints and Git versioning, documenting the application of theoretical concepts in practice.

---

## Development Log - Sprint 1: Foundation and Initial Navigation

The goal of this Sprint is to establish the base architecture of the project and implement the navigation flow from the Splash screen to the List screen.

### ✅ Task 0: Environment Setup and Clean Architecture
* **Status:** Completed
* **Description:** Git repository setup, Android project structure creation, and enabling essential tools for clean and safe development.
* **Applied Concepts:**
    * `View Binding`: Enabled in `build.gradle.kts` to replace `findViewById()` and ensure type-safe access to views, as covered in **Class 4 (09/25/2025) - Building the 1st App / View Binding**.

### ⏳ Task 1: Implementation of `SplashActivity` and Navigation
* **Status:** In progress
* **Description:** Creation of the initial splash screen, with a timer for automatic transition to the main screen and correct Back Stack management.
* **Applied Concepts:**
    * Creating `Activity`: **Class 4 (09/25/2025) - Building the 1st App**.
    * Explicit `Intent`: To start `MainActivity` from `SplashActivity`. Covered in **Class 5 (09/30/2025) - App Navigation**.
    * Back Stack management with `finish()`: To prevent the user from returning to the Splash Screen. Covered in **Class 5 (09/30/2025) - App Navigation**.

### 🔲 Task 2: Data Structure (`data class`) and List Item Layout
* **Status:** Pending
* **Planned Concepts:**
    * `data class`: To model Pokémon data. Covered in **Class 3 (09/18/2025) - OOP**.
    * `ConstraintLayout`: To build the layout for each list item. Covered in **Class 4 (09/25/2025) - Layouts**.

### 🔲 Task 3: Building the `RecyclerView.Adapter`
* **Status:** Pending
* **Planned Concepts:**
    * `RecyclerView` and `Adapter`: For efficient list display. Covered in **Class 4 (09/25/2025) - Layouts**.
    * Higher-Order Functions (Lambda): To handle click events on each item. Covered in **Class 2 (09/11/2025) - Functions**.

---

## 🛠 Technologies and Libraries

* **Language:** Kotlin
* **Architecture:** MVVM (to be implemented)
* **Android Jetpack Libraries:**
    * View Binding
    * Navigation Component (to be implemented)
    * ViewModel (to be implemented)
    * RecyclerView
* **Networking:** Retrofit & Coroutines (to be implemented)
* **Images:** Coil/Glide (to be implemented)
