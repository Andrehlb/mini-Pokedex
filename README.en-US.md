<p align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</p>

---

# 🎮 Mini-Pokedex (Native Android with Kotlin)

A Pokédex app for Android, developed in **Kotlin** as the final project for the **Venturus Native Android** course. The project consumes the public **PokéAPI v2** and features a fluid experience with list screens, details, search, and advanced filters.

The project follows the **MVVM** architecture and implements Jetpack best practices, including ViewModel, LiveData, DataBinding, SplashScreen API, plus Coroutines, Retrofit, Coil for image loading, and Lottie for animations.

---

## 🚀 How to Run / Setup

### 📋 Prerequisites

- **Android Studio** (latest version recommended)
- **Android SDK** (compileSdk = 36, minSdk = 24)
- **Kotlin** 2.0.0 or higher
- **Gradle** 8.x

### ⚙️ Installation Steps

#### 1️⃣ **Clone the repository:**

```bash
git clone https://github.com/Andrehlb/mini-Pokedex.git
cd mini-Pokedex
```

#### 2️⃣ **Open in Android Studio:**

- Open Android Studio
- Select **File > Open**
- Navigate to the `mini-Pokedex` folder and click **Open**

#### 3️⃣ **Configure the Android SDK (if necessary):**

- Go to **Tools > SDK Manager**
- Make sure you have installed:
    - **Android SDK Platform 36** (compileSdk)
    - **Android SDK Platform 24** (minSdk)
    - **Android Emulator** (or connect a physical device)

#### 4️⃣ **Build the Project:**

Gradle will automatically download all dependencies.

```bash
./gradlew build
```

#### 5️⃣ **Running the App:**

- Connect an emulator or physical device
- Click **Run > Run 'app'** (Shift + F10)
- Or via terminal:

```bash
./gradlew installDebug
```

### 🔗 Network Requirements

The app requires an **internet connection** to consume the **PokéAPI v2**:

- **Base Endpoint:** `https://pokeapi.co/api/v2/`
- **Required permission:** `android.permission.INTERNET` (already added in AndroidManifest.xml)

---

## ✅ Final Project Status

**🏆 PROJECT 100% FUNCTIONAL AND COMPLETE!**

### Implemented Features:

| Feature | Status | Details |
|---|---|---|
| **Splash Screen** | ✅ Complete | Initial screen with animation |
| **RecyclerView** | ✅ Complete | List of 1,025 Pokémon |
| **Name + Image** | ✅ Complete | Loaded via Coil |
| **Search by Name** | ✅ Complete | Real-time filter (EditText) |
| **Filter by Type** | ✅ Complete | 18 types (Fire, Water, Grass, etc.) |
| **Filter by Generation** | ✅ Complete | Gen I to Gen IX (Spinner) |
| **Detail Screen** | ✅ Complete | Name, ID, Image, Types, Height, Weight |
| **Pokémon Stats** | ✅ Complete | HP, Attack, Defense |
| **Integrated Filters** | ✅ Complete | Work together with search |
| **Compilation** | ✅ No Errors | Successful build |

### 📊 Requirements Coverage:

✅ **Splash Screen** - Created and working
✅ **List Screen** - RecyclerView + search + dual filters
✅ **Detail Screen** - All Pokémon information
✅ **Navigation** - Correct Intent between screens
✅ **API Integration** - 1,025 Pokémon loaded

---

## 📸 Screenshots / GIFs

### Splash Screen
![Splash Screen](assets/splash_screen.png)

### List Screen with Search
![Pokémon List](assets/pokemon_list.png)

### Active Filters
![Filters by Type and Generation](assets/filters.png)

### Detail Screen
![Pokémon Details](assets/pokemon_detail.png)

---

## Development Log - Sprints

### Sprint 1: Foundation and Visual Structure ✅ (Completed)

- **Description:** Project base, modern Splash Screen, Constraint/RecyclerView layouts, Intent navigation
- **Concepts:** Android Lifecycle, LayoutInflater, Intent
- **Artifacts:**
    - SplashActivity.kt
    - MainActivity.kt (base layout)
    - activity_main.xml
    - activity_splash.xml

### Sprint 2: UI Layer and Reactive State ✅ (Completed)

- **Description:** MVVM with ViewModels, LiveData observers, RecyclerView with dynamic data, coroutines for API fetch
- **Concepts:** MVVM Architecture, Lambda callbacks, LiveData observers
- **Artifacts:**
    - PokemonListViewModel.kt
    - DetailViewModel.kt
    - PokemonAdapter.kt
    - DataBinding in XMLs

### Sprint 3: Persistence, Animations, and Advanced UI ✅ (Completed)

- **Description:** Loading of 1,025 Pokémon, Lottie for loading animations, combined filters (type + generation), integrated search
- **Concepts:** Lottie animations, Spinner widgets, TextWatcher for search
- **Artifacts:**
    - activity_main.xml (spinners + EditText)
    - PokemonListViewModel.kt (filter logic)
    - Lottie JSON animations

### Sprint 4: Data and Network Layer ✅ (Completed)

- **Description:** Retrofit PokeAPI, JSON response models, coroutines for asynchronous requests
- **Concepts:** Retrofit + Gson, Coroutines, REST API
- **Artifacts:**
    - RetrofitClient.kt
    - PokeApiService.kt
    - PokemonResponse.kt
    - PokemonDetailResponse.kt

### Sprint 5: Polishing and Delivery ✅ (Completed)

- **Description:** Code refactoring, error validation, improved UX, documentation
- **Concepts:** Error handling, User feedback
- **Artifacts:**
    - BindingAdapters.kt (data formatting)
    - Toast/Loading indicators
    - Documented README

---

## 🛠 Technologies and Libraries

### Core Android

- **Language:** Kotlin 2.0.0
- **Architecture:** MVVM (Model-View-ViewModel)
- **Build System:** Gradle Kotlin DSL

### Jetpack

- **ViewModel** - State management
- **LiveData** - Reactive data observation
- **DataBinding** - Binding between XML layout and ViewModel
- **SplashScreen API** - Native splash screen for Android 12+
- **RecyclerView** - Efficient list rendering
- **Constraint Layout** - Responsive layouts

### Network and API

- **Retrofit 2.11.0** - HTTP client
- **Gson** - JSON serialization/deserialization
- **Coil 2.7.0** - Image loading

### Asynchrony

- **Coroutines 1.8.1** - Asynchronous programming
- **viewModelScope** - Coroutine scope for ViewModel

### Animations

- **Lottie 6.4.0** - Vector animations

### Testing

- **JUnit 4** - Unit tests
- **Espresso** - UI tests

---

## 📁 Folder Structure

```
app/src/main/
├── java/br/com/venturus/andrehlb/minipokedex/
│   ├── MainActivity.kt                    # Main screen with list
│   ├── DetailActivity.kt                  # Detail screen
│   ├── SplashActivity.kt                  # Splash screen
│   ├── PokemonAdapter.kt                  # RecyclerView Adapter
│   ├── model/
│   │   ├── Pokemon.kt                     # Pokemon model
│   │   ├── PokemonResponse.kt             # API list response
│   │   └── PokemonDetailResponse.kt       # API detail response
│   ├── viewmodel/
│   │   ├── PokemonListViewModel.kt        # List ViewModel
│   │   └── DetailViewModel.kt             # Detail ViewModel
│   ├── network/
│   │   ├── PokeApiService.kt              # Retrofit interface
│   │   └── RetrofitClient.kt              # Retrofit configuration
│   ├── utils/
│   │   └── BindingAdapters.kt             # Data Binding adapters
│   └── adapter/
│       └── PokemonDiffCallback.kt         # DiffUtil callback
├── res/
│   ├── layout/
│   │   ├── activity_main.xml              # Main layout
│   │   ├── activity_detail.xml            # Detail layout
│   │   ├── activity_splash.xml            # Splash layout
│   │   └── item_pokemon.xml               # RecyclerView item layout
│   ├── drawable/
│   │   ├── ic_pokemon_placeholder.xml     # Placeholder image
│   │   └── ic_error.xml                   # Error image
│   ├── anim/
│   │   └── splash_animation.json          # Lottie animation
│   └── values/
│       ├── strings.xml                    # App strings
│       └── colors.xml                     # App colors
└── AndroidManifest.xml                    # Manifest
```

---

## 🔧 Dependency Configuration

Dependencies are defined in `app/build.gradle.kts`:

```gradle
// Jetpack
implementation("androidx.core:core-ktx:1.13.1")
implementation("androidx.appcompat:appcompat:1.7.0")
implementation("androidx.constraintlayout:constraintlayout:2.1.4")
implementation("androidx.recyclerview:recyclerview:1.3.2")

// ViewModel & LiveData
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")

// DataBinding
implementation("androidx.databinding:databinding-runtime:8.5.0")

// SplashScreen
implementation("androidx.core:core-splashscreen:1.0.1")

// Retrofit & Gson
implementation("com.squareup.retrofit2:retrofit:2.11.0")
implementation("com.squareup.retrofit2:converter-gson:2.11.0")

// Coroutines
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

// Coil (Image Loading)
implementation("io.coil-kt:coil:2.7.0")

// Lottie
implementation("com.airbnb.android:lottie:6.4.0")
```

---

## 🐛 Troubleshooting

### Error: "compileSdk = 36 is too new"

**Solution:** Update the Android SDK to version 36:
```bash
Tools > SDK Manager > Android 15 (API 36)
```

### Error: "Cannot find symbol: PokeApiService"

**Solution:** Run `Build > Clean Project` and then `Build > Rebuild Project`

### Images not loading

**Check:**
1. Is the internet connection active?
2. Is the image URL correct in `Pokemon.kt`?
3. Is the `INTERNET` permission in `AndroidManifest.xml`?

### App crashes when filtering

**Check:**
1. Is the Spinner value not null?
2. Is `applyFilters()` handling exceptions?

---

## 📚 References and Links

- **PokeAPI v2 Documentation:** https://pokeapi.co/docs/v2
- **Android Developers:** https://developer.android.com
- **Kotlin Documentation:** https://kotlinlang.org/docs
- **Jetpack Components:** https://developer.android.com/jetpack
- **Retrofit Documentation:** https://square.github.io/retrofit/

---

## 🙏 Acknowledgements

- **Felipe Dapolo, Vinicius Silva, Steffeson Wesley Lira** - Teachers and mentors of the Venturus Native Android track
- **Jéssica V. Dos S. Albertin, Maressa P. C. P. Ramalho, Raíssa Mayara da Silva** - from the **Human Development** team, for their support, attention, and care throughout this journey.
- **Venturus** - For the opportunity and course structure
- **Google** - For the Android SDK and Jetpack
- **Square** - For Retrofit
- **Airbnb** - For Lottie
- **PokeAPI Community** - For the public Pokémon API

---

## 📄 License

This project is provided as part of the Venturus Native Android course. Educational use is permitted.

---

**Developed with ❤️ by André Luiz Brbosa (Andrehlb)**  
**Last updated:** November 9, 2025
