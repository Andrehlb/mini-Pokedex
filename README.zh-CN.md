<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>

</div>

---

# Mini-Pokedex（原生Android，Kotlin）

这是一个简单的宝可梦图鉴（Pokedex）App，基于Kotlin开发，作为Venturus原生Android课程的期末项目。本项目消费公开的PokéAPI，并包含列表、详情页及搜索功能。

项目遵循 **MVVM (Model-View-ViewModel)** 架构和Android最佳实践，例如使用 **Jetpack组件 (ViewModel, LiveData, DataBinding, SplashScreen API)**，并采用Git进行版本控制和增量式文档记录。

---

## 开发日志 - Sprint 1：MVVM架构、Jetpack与基础UI

本Sprint的目标是使用MVVM建立应用的架构基础，通过`ViewModel`掌握生命周期和状态持久化，并使用现代化的Jetpack组件构建初始用户界面。

---

### ✅ 任务0：环境与项目配置
* **状态：** 已完成
* **描述：** 在GitHub上完成仓库的初始配置，并在Android Studio中完成项目的基本设置和依赖项添加。

---

### ✅ 任务1：理解与可视化Activity生命周期
* **状态：** 已完成
* **描述：** 在`MainActivity`中实现了所有生命周期方法`Log.d`日志记录，用于分析和调试Activity的行为。

---

### ✅ 任务2：实现启动页（现代化方案）
* **状态：** 已完成
* **描述：** 使用了Jetpack的 **`SplashScreen API`**，而非手动创建`SplashActivity`。通过在`MainActivity`中调用`installSplashScreen()`完成配置，由API自动管理过渡动画。这避免了使用显式`Intent`和手动管理返回栈（`finish()`）。
* **应用概念：**
  * `SplashScreen API`：用于实现现代化、高效启动页的Jetpack库。

---

### ✅ 任务3：采用MVVM架构与ViewModel、Data Binding
* **状态：** 已完成
* **描述：** 将业务逻辑从`MainActivity`迁移至`PokemonListViewModel`。`ViewModel`现在负责管理UI数据和状态。配置了`DataBinding`将`activity_main.xml`布局文件与`ViewModel`直接连接，使UI能够响应状态变化（如`isLoading`）。
* **应用概念：**
  * **`ViewModel`**：管理UI相关数据，并在配置变更（如屏幕旋转）后继续存在，替代了`onSaveInstanceState`。
  * **`DataBinding`**：以声明方式将UI（XML）与数据逻辑（ViewModel）绑定。
  * **`LiveData`**：创建可观察的数据流供UI消费。

---

### ⏳ 任务4：使用RecyclerView构建UI结构
* **状态：** 进行中
* **描述：** 已使用`CardView`和`ConstraintLayout`创建了列表的单项布局（`item_pokemon.xml`）。下一步是在`activity_main.xml`中添加`RecyclerView`，并创建`PokemonAdapter`来管理宝可梦列表的显示。
* **应用/计划概念：**
  * `RecyclerView`与`Adapter`：高效地显示列表。
  * `ViewHolder`：管理列表项视图的标准模式。

---

### 🔲 任务5：导航与数据层
* **状态：** 待办
* **描述：** 实现点击列表项后从`MainActivity`导航到`DetailActivity`的功能。使用`Repository`和`Retrofit`构建数据层，以消费PokéAPI。
* **计划概念：**
  * `Repository模式`：管理数据源（网络和本地缓存）。
  * `Retrofit`与`Coroutines`：异步执行网络请求。
  * `Intent`与`extras`：在Activities之间传递数据（如宝可梦ID）。

---

## 🛠 技术与库

* **语言：** Kotlin
* **架构：** **MVVM（实施中）**
* **Android Jetpack库：**
  * **ViewModel（已实现）**
  * **DataBinding（已实现）**
  * **SplashScreen API（已实现）**
  * View Binding
  * RecyclerView（实施中）
* **网络：** Retrofit & Coroutines（待实现）

---

## 备注

- 对于复杂的、生命周期较长的数据，使用`ViewModel`可以替代`onSaveInstanceState`和`Bundle`进行手动的状态保存与恢复。
