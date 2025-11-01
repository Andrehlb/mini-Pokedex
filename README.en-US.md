<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</div>

---

# Mini-Pokedex (Native Android with Kotlin)

A simple Pokedex app for Android, developed in Kotlin as the final project for the Venturus Native Android course. The project consumes the public PokéAPI and features list and detail screens with search, filters, Lottie animations, and basic offline support.

The project follows the **MVVM** architecture and best practices, such as Jetpack (ViewModel, LiveData, DataBinding, SplashScreen API, Room, WorkManager), coroutines, Retrofit, and Lottie for animations.

---

## Development Log - Updated Sprints (based on review 10/30/2025)

Objective: Mandatory (animated splash, RecyclerView list + image/name, search/filters for types/generations, details with name/ID/image/types/height/weight/stats) + viable extras (offline sync, Pokéball animation, social share).

### Sprint 1: Foundation and Visual Structure (Completed)
* **Description:** Base, modern splash, layouts, Intent navigation.
* **Concepts:** Lifecycle, Constraint/Recycler layouts.

### Sprint 2: UI Layer and Reactive State (In Progress)
* **Description:** MVVM ViewModels, LiveData observers, RecyclerView with fake data, coroutines fetch.
* **Concepts:** UI architecture, lambda callbacks.

### Sprint 3: Persistence, Animations, and Advanced UI (Next Focus)
* **Description:** Room DAO/Repo, Lottie Pokéball splash/loading, combined filters/search, offline cache.
* **Concepts:** Asynchronous Room/WorkManager, animations.

### Sprint 4: Data and Network Layer
* **Description:** Retrofit PokeAPI, Room sync, connection check.
* **Concepts:** Network with coroutines.

### Sprint 5: Extras and Polishing (Optional)
* **Description:** AR-lite selfie (CameraX/Gemini), WorkManager notifications, share Intent, tests.
* **Concepts:** Background tasks, AI APIs.

---

## 🛠 Technologies and Libraries

* **Language:** Kotlin
* **Architecture:** MVVM
* **Jetpack:** ViewModel/LiveData/DataBinding/SplashScreen/Room/Navigation/RecyclerView/WorkManager
* **Asynchrony:** Coroutines
* **Network:** Retrofit/Coil
* **Animations:** Lottie
* **Others:** KSP (Room)

---