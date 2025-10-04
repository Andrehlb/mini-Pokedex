<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</div>

---

# Mini-Pokedex (Native Android with Kotlin)

A simple Pokedex app for Android, developed in Kotlin as the final project for the Venturus Native Android course. It features list/detail screens, search/filter functionality, and consumes the public PokéAPI.

This project is being developed following Android best practices, with sprints, Git versioning, and incremental documentation of theoretical and practical concepts learned throughout the course.

---

## Development Log - Sprint 1: Foundation, Lifecycle, and Initial Navigation

The goal of this Sprint is to establish the project's architectural foundation, master the lifecycle of Activities and Fragments, implement navigation between screens (Single-Activity/Fragment Architecture with Navigation Component), and ensure state persistence during configuration changes.

---

### ✅ Task 0: Environment and Project Setup
* **Status:** Completed
* **Subtasks:**
  1. Create a GitHub repository with `README.md`, `.gitignore` (Android), and `LICENSE` (MIT).
  2. Initialize the Android Studio project (`Empty Views Activity`).
  3. Enable View Binding in `build.gradle.kts`.
  4. Initial commit with the basic structure.
* **Reference:**  
  **Class 4 (09/25/2025) — Building the 1st App / View Binding**
* **Expected Result:**  
  Project compiles, runs, and the initial structure is versioned.

---

### ✅ Task 1: Understanding and Visualizing the Activity Lifecycle
* **Status:** Completed
* **Description:** Implementation of logs (`Log.d`) in all lifecycle methods (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`, `onRestart`) in `MainActivity`. Running the app, analyzing logs in Logcat, and using Debug mode for practical understanding of the lifecycle.
* **Applied Concepts:**
  * Android Activity lifecycle methods and their calls, as covered in **Class 6 (10/02/2025) – Lifecycle and Debugging**.

---

### ⏳ Task 2: Implementation of `SplashActivity` and Navigation
* **Status:** In progress
* **Description:** Creation of the splash screen, with a timer for automatic transition to the main screen and correct Back Stack management.
* **Applied Concepts:**
  * Creating `Activity`: **Class 4 (09/25/2025) - Building the 1st App**.
  * Explicit `Intent`: To start `MainActivity` from `SplashActivity`. Covered in **Class 5 (09/30/2025) - App Navigation**.
  * Back Stack management with `finish()`: To prevent the user from returning to the Splash Screen. Covered in **Class 5 (09/30/2025) - App Navigation**.

---

### ⏳ Task 3: Saving and Restoring State (onSaveInstanceState/Bundle)
* **Status:** In progress
* **Description:** Implement state persistence during configuration changes (e.g., screen rotation), using `onSaveInstanceState` and `Bundle` to save/restore important variable states.
* **Applied Concepts:**
  * State persistence in Activities.
  * Use of Bundle and lifecycle methods to save/restore data.
  * **Class 6 (10/02/2025) – Lifecycle, State, and Debugging**

---

### 🔲 Task 4: Single-Activity Architecture, Fragments, and Navigation Component
* **Status:** Pending
* **Description:** Migrate navigation to a Fragment-based architecture, create and configure the Navigation Component, implement safe navigation between screens, and advanced Back Stack control.
* **Planned Concepts:**
  * Fragment lifecycle (`onCreate`, `onCreateView`, `onViewCreated`, `onDestroyView`)
  * Use of the Navigation Component (`nav_graph.xml`, actions, Safe Args, popUpTo)
  * **Class 6 (10/02/2025) – Fragments and Advanced Navigation**

---

### 🔲 Task 5: Data Structure, Layouts, and Adapter
* **Status:** Pending
* **Planned Concepts:**
  * `data class`: To model Pokémon data. Covered in **Class 3 (09/18/2025) - OOP**.
  * `ConstraintLayout`: To build the layout for each list item. Covered in **Class 4 (09/25/2025) - Layouts**.
  * `RecyclerView` and `Adapter`: For efficient list display.
  * Higher-Order Functions (Lambda): To handle click events on each item.
  * **Class 2 (09/11/2025) - Functions**

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

---

## Notes

- [REVIEW] Points marked as “XXX” or doubts in class notes should be clarified before moving on to the next Sprint.
- TODO: Start API integration and instrumented tests in a future Sprint.
- Always ensure the app compiles, runs, and logs correctly before each commit.

---

## Reference Standard for Class/Content Citations

- Always cite:  
  **Class X (MM/DD/YYYY) – Topic**
- Mark doubts with `[REVIEW]` and reference the original PDF/note.
- Example:  
  `onSaveInstanceState: **Class 6 (10/02/2025) – Lifecycle and State Persistence.** [REVIEW]`
