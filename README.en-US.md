<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</div>

---

# Mini-Pokedex (Native Android with Kotlin)

A simple Pokedex app for Android, developed in Kotlin as the final project for the Venturus Native Android course. The project consumes the public PokéAPI and features list/detail screens with search functionality.

This project follows the **MVVM (Model-View-ViewModel)** architecture and Android development best practices, such as using **Jetpack components (ViewModel, LiveData, DataBinding, SplashScreen API)**, Git versioning, and incremental documentation.

---

## Development Log - Sprint 1: MVVM Architecture, Jetpack, and Basic UI

The goal of this Sprint is to establish the app's architectural foundation using MVVM, master lifecycle and state persistence with `ViewModel`, and build the initial UI with modern Jetpack components.

---

### ✅ Task 0: Environment and Project Setup
* **Status:** Completed
* **Description:** Initial setup of the GitHub repository and the Android Studio project with basic dependencies.

---

### ✅ Task 1: Understanding and Visualizing the Activity Lifecycle
* **Status:** Completed
* **Description:** Implemented logs (`Log.d`) in all `MainActivity` lifecycle methods to analyze and debug the Activity's behavior.

---

### ✅ Task 2: Splash Screen Implementation (Modern Approach)
* **Status:** Completed
* **Description:** Instead of a manual `SplashActivity`, the Jetpack **`SplashScreen API`** was used. The setup was done via `installSplashScreen()` in `MainActivity`, which handles the transition automatically. This eliminates the need for explicit `Intent`s and Back Stack management with `finish()`.
* **Applied Concepts:**
  * `SplashScreen API`: A Jetpack library for a modern and efficient startup screen.

---

### ✅ Task 3: MVVM Architecture with ViewModel and Data Binding
* **Status:** Completed
* **Description:** Logic was moved from `MainActivity` to `PokemonListViewModel`. The `ViewModel` is now responsible for managing UI data and state. `DataBinding` was set up to connect the `activity_main.xml` layout directly to the `ViewModel`, allowing the UI to react to state changes (like `isLoading`).
* **Applied Concepts:**
  * **`ViewModel`**: To manage UI-related data and survive configuration changes (replacing `onSaveInstanceState`).
  * **`DataBinding`**: To declaratively bind UI (XML) to data logic (ViewModel).
  * **`LiveData`**: To create observable data streams that the UI can consume.

---

### ⏳ Task 4: UI Structure with RecyclerView
* **Status:** In progress
* **Description:** The layout for an individual list item (`item_pokemon.xml`) has been created using `CardView` and `ConstraintLayout`. The next step is to add the `RecyclerView` to `activity_main.xml` and create the `PokemonAdapter` to manage the list display.
* **Applied/Planned Concepts:**
  * `RecyclerView` and `Adapter`: For efficient list display.
  * `ViewHolder`: A pattern to manage the views for each item.

---

### 🔲 Task 5: Navigation and Data Layer
* **Status:** Pending
* **Description:** Implement navigation from `MainActivity` to `DetailActivity` upon clicking a list item. Build the data layer with `Repository` and `Retrofit` to consume the PokéAPI.
* **Planned Concepts:**
  * `Repository Pattern`: To manage data sources (network and local cache).
  * `Retrofit` & `Coroutines`: To perform network calls asynchronously.
  * `Intent` with `extras`: To pass data (like the Pokémon ID) between Activities.

---

## 🛠 Technologies and Libraries

* **Language:** Kotlin
* **Architecture:** **MVVM (in implementation)**
* **Android Jetpack Libraries:**
  * **ViewModel (Implemented)**
  * **DataBinding (Implemented)**
  * **SplashScreen API (Implemented)**
  * View Binding
  * RecyclerView (in implementation)
* **Networking:** Retrofit & Coroutines (to be implemented)

---

## Notes

- The use of `ViewModel` replaces the need to manually save and restore state with `onSaveInstanceState` and `Bundle` for complex and long-lived data.
