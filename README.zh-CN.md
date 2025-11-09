<p align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>

</p>

---

# 🎮 迷你宝可梦图鉴 (原生Android与Kotlin)

一款安卓宝可梦图鉴应用，使用**Kotlin**作为**Venturus原生Android**课程的最终项目开发。该项目使用公共的**PokéAPI v2**，并提供流畅的体验，包括列表、详情、搜索和高级筛选页面。

项目遵循**MVVM**架构，并实施了Jetpack的最佳实践，包括ViewModel、LiveData、DataBinding、SplashScreen API，以及协程、Retrofit、用于图片加载的Coil和用于动画的Lottie。

---

## 🚀 如何运行 / 设置

### 📋 先决条件

- **Android Studio** (推荐最新版本)
- **Android SDK** (compileSdk = 36, minSdk = 24)
- **Kotlin** 2.0.0 或更高版本
- **Gradle** 8.x

### ⚙️ 安装步骤

#### 1️⃣ **克隆仓库:**

```bash
git clone https://github.com/Andrehlb/mini-Pokedex.git
cd mini-Pokedex
```

#### 2️⃣ **在Android Studio中打开:**

- 打开 Android Studio
- 选择 **File > Open**
- 导航到 `mini-Pokedex` 文件夹并点击 **Open**

#### 3️⃣ **配置Android SDK (如果需要):**

- 前往 **Tools > SDK Manager**
- 确保已安装:
    - **Android SDK Platform 36** (compileSdk)
    - **Android SDK Platform 24** (minSdk)
    - **Android Emulator** (或连接物理设备)

#### 4️⃣ **构建项目:**

Gradle将自动下载所有依赖项。

```bash
./gradlew build
```

#### 5️⃣ **运行应用:**

- 连接模拟器或物理设备
- 点击 **Run > Run 'app'** (Shift + F10)
- 或通过终端:

```bash
./gradlew installDebug
```

### 🔗 网络要求

应用需要**互联网连接**以使用**PokéAPI v2**:

- **基础端点:** `https://pokeapi.co/api/v2/`
- **所需权限:** `android.permission.INTERNET` (已在AndroidManifest.xml中添加)

---

## ✅ 项目最终状态

**🏆 项目100%功能齐全并完成！**

### 已实现功能:

| 功能 | 状态 | 详情 |
|---|---|---|
| **闪屏** | ✅ 完成 | 带动画的初始屏幕 |
| **RecyclerView** | ✅ 完成 | 1,025只宝可梦列表 |
| **名称 + 图片** | ✅ 完成 | 通过Coil加载 |
| **按名称搜索** | ✅ 完成 | 实时筛选 (EditText) |
| **按类型筛选** | ✅ 完成 | 18种类型 (火, 水, 草, 等) |
| **按世代筛选** | ✅ 完成 | I代至IX代 (Spinner) |
| **详情屏幕** | ✅ 完成 | 名称, ID, 图片, 类型, 身高, 体重 |
| **宝可梦统计数据** | ✅ 完成 | HP, 攻击, 防御 |
| **集成筛选** | ✅ 完成 | 与搜索功能协同工作 |
| **编译** | ✅ 无错误 | 构建成功 |

### 📊 需求覆盖情况:

✅ **闪屏** - 已创建并正常工作
✅ **列表屏幕** - RecyclerView + 搜索 + 双重筛选
✅ **详情屏幕** - 所有宝可梦信息
✅ **导航** - 屏幕间Intent正确
✅ **API集成** - 已加载1,025只宝可梦

---

## 📸 截图 / GIF

### 闪屏
![Splash Screen](assets/splash_screen.png)

### 带搜索的列表屏幕
![Pokémon List](assets/pokemon_list.png)

### 激活的筛选器
![Filters by Type and Generation](assets/filters.png)

### 详情屏幕
![Pokémon Details](assets/pokemon_detail.png)

---

## 开发日志 - Sprints

### Sprint 1: 基础和视觉结构 ✅ (已完成)

- **描述:** 项目基础, 现代闪屏, Constraint/RecyclerView布局, Intent导航
- **概念:** Android生命周期, LayoutInflater, Intent
- **产物:**
    - SplashActivity.kt
    - MainActivity.kt (基础布局)
    - activity_main.xml
    - activity_splash.xml

### Sprint 2: UI层和响应式状态 ✅ (已完成)

- **描述:** 使用ViewModels的MVVM, LiveData观察者, 动态数据的RecyclerView, 用于API获取的协程
- **概念:** MVVM架构, Lambda回调, LiveData观察者
- **产物:**
    - PokemonListViewModel.kt
    - DetailViewModel.kt
    - PokemonAdapter.kt
    - XML中的DataBinding

### Sprint 3: 持久化、动画和高级UI ✅ (已完成)

- **描述:** 加载1,025只宝可梦, 用于加载动画的Lottie, 组合筛选 (类型 + 世代), 集成搜索
- **概念:** Lottie动画, Spinner小部件, 用于搜索的TextWatcher
- **产物:**
    - activity_main.xml (spinners + EditText)
    - PokemonListViewModel.kt (筛选逻辑)
    - Lottie JSON动画

### Sprint 4: 数据和网络层 ✅ (已完成)

- **描述:** Retrofit PokeAPI, JSON响应模型, 用于异步请求的协程
- **概念:** Retrofit + Gson, 协程, REST API
- **产物:**
    - RetrofitClient.kt
    - PokeApiService.kt
    - PokemonResponse.kt
    - PokemonDetailResponse.kt

### Sprint 5: 润色和交付 ✅ (已完成)

- **描述:** 代码重构, 错误验证, 改进的用户体验, 文档
- **概念:** 错误处理, 用户反馈
- **产物:**
    - BindingAdapters.kt (数据格式化)
    - Toast/加载指示器
    - 记录的README

---

## 🛠 技术和库

### 核心Android

- **语言:** Kotlin 2.0.0
- **架构:** MVVM (Model-View-ViewModel)
- **构建系统:** Gradle Kotlin DSL

### Jetpack

- **ViewModel** - 状态管理
- **LiveData** - 响应式数据观察
- **DataBinding** - XML布局和ViewModel之间的绑定
- **SplashScreen API** - Android 12+原生闪屏
- **RecyclerView** - 高效列表渲染
- **Constraint Layout** - 响应式布局

### 网络和API

- **Retrofit 2.11.0** - HTTP客户端
- **Gson** - JSON序列化/反序列化
- **Coil 2.7.0** - 图片加载

### 异步

- **Coroutines 1.8.1** - 异步编程
- **viewModelScope** - ViewModel的协程作用域

### 动画

- **Lottie 6.4.0** - 矢量动画

### 测试

- **JUnit 4** - 单元测试
- **Espresso** - UI测试

---

## 📁 文件夹结构

```
app/src/main/
├── java/br/com/venturus/andrehlb/minipokedex/
│   ├── MainActivity.kt                    # 主屏幕列表
│   ├── DetailActivity.kt                  # 详情屏幕
│   ├── SplashActivity.kt                  # 闪屏
│   ├── PokemonAdapter.kt                  # RecyclerView适配器
│   ├── model/
│   │   ├── Pokemon.kt                     # 宝可梦模型
│   │   ├── PokemonResponse.kt             # API列表响应
│   │   └── PokemonDetailResponse.kt       # API详情响应
│   ├── viewmodel/
│   │   ├── PokemonListViewModel.kt        # 列表ViewModel
│   │   └── DetailViewModel.kt             # 详情ViewModel
│   ├── network/
│   │   ├── PokeApiService.kt              # Retrofit接口
│   │   └── RetrofitClient.kt              # Retrofit配置
│   ├── utils/
│   │   └── BindingAdapters.kt             # Data Binding适配器
│   └── adapter/
│       └── PokemonDiffCallback.kt         # DiffUtil回调
├── res/
│   ├── layout/
│   │   ├── activity_main.xml              # 主布局
│   │   ├── activity_detail.xml            # 详情布局
│   │   ├── activity_splash.xml            # 闪屏布局
│   │   └── item_pokemon.xml               # RecyclerView项目布局
│   ├── drawable/
│   │   ├── ic_pokemon_placeholder.xml     # 占位符图片
│   │   └── ic_error.xml                   # 错误图片
│   ├── anim/
│   │   └── splash_animation.json          # Lottie动画
│   └── values/
│       ├── strings.xml                    # 应用字符串
│       └── colors.xml                     # 应用颜色
└── AndroidManifest.xml                    # 清单文件
```

---

## 🔧 依赖配置

依赖项在`app/build.gradle.kts`中定义:

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

## 🐛 问题排查

### 错误: "compileSdk = 36 is too new"

**解决方案:** 更新Android SDK到版本36:
```bash
Tools > SDK Manager > Android 15 (API 36)
```

### 错误: "Cannot find symbol: PokeApiService"

**解决方案:** 运行 `Build > Clean Project` 然后 `Build > Rebuild Project`

### 图片不加载

**检查:**
1. 互联网连接是否激活?
2. `Pokemon.kt`中的图片URL是否正确?
3. `INTERNET`权限是否在`AndroidManifest.xml`中?

### 筛选时应用崩溃

**检查:**
1. Spinner的值是否不为null?
2. `applyFilters()`是否处理了异常?

---

## 📚 参考和链接

- **PokeAPI v2 Documentation:** https://pokeapi.co/docs/v2
- **Android Developers:** https://developer.android.com
- **Kotlin Documentation:** https://kotlinlang.org/docs
- **Jetpack Components:** https://developer.android.com/jetpack
- **Retrofit Documentation:** https://square.github.io/retrofit/

---

## 🙏 致谢

- **Felipe Dapolo, Vinicius Silva, Steffeson Wesley Lira** - Venturus原生Android课程的老师和导师
- **Jéssica V. Dos S. Albertin, Maressa P. C. P. Ramalho, Raíssa Mayara da Silva** - 来自**人力发展**团队，感谢他们在整个过程中的支持、关注和关心。
- **Venturus** - 提供课程机会和结构
- **Google** - 提供Android SDK和Jetpack
- **Square** - 提供Retrofit
- **Airbnb** - 提供Lottie
- **PokeAPI Community** - 提供公共的宝可梦API

---

## 📄 许可证

本项目作为Venturus原生Android课程的一部分提供。允许用于教育目的。

---

**由 André Luiz Brbosa (Andrehlb) 用 ❤️ 开发**  
**最后更新:** 2025年11月9日
