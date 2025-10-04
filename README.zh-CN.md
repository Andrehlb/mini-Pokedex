<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>

</div>

---

# Mini-Pokedex（原生Android，Kotlin）

这是一个简单的宝可梦图鉴（Pokedex）App，基于Kotlin开发，作为Venturus原生Android课程的期末项目。包含宝可梦列表、详情页、搜索和筛选功能，并消费公开的PokéAPI。

本项目遵循Android最佳实践，采用敏捷Sprints流程，Git版本管理，并持续记录课程中的理论与实操知识。

---

## 开发日志 - Sprint 1：基础、生命周期与导航

本Sprint目标是建立项目的架构基础，掌握Activity和Fragment的生命周期，实现各页面间的导航（Single-Activity/Fragment架构，使用Navigation Component），并保证配置变更时的状态持久化。

---

### ✅ 任务0：环境与项目配置
* **状态：** 已完成
* **子任务：**
  1. 创建GitHub仓库，包含`README.md`、`.gitignore`（Android）和`LICENSE`（MIT）。
  2. 使用Android Studio初始化项目（Empty Views Activity）。
  3. 在`build.gradle.kts`中启用View Binding。
  4. 提交初始结构。
* **参考：**  
  **第4课（2025/09/25）— 构建第一个App / View Binding**
* **预期结果：**  
  项目可编译、运行，基础结构已提交到版本库。

---

### ✅ 任务1：理解与可视化Activity生命周期
* **状态：** 已完成
* **描述：** 在`MainActivity`中覆写全部生命周期方法（`onCreate`、`onStart`、`onResume`、`onPause`、`onStop`、`onDestroy`、`onRestart`），每个方法内添加`Log.d`日志，通过Logcat和调试模式直观分析生命周期事件。
* **应用概念：**
  * Android Activity生命周期方法与调用顺序，见**第6课（2025/10/02）— 生命周期与调试**

---

### ⏳ 任务2：实现`SplashActivity`及导航
* **状态：** 进行中
* **描述：** 创建启动页（Splash），定时自动跳转到主页面，正确处理返回栈。
* **应用概念：**
  * 创建Activity：**第4课（2025/09/25）**
  * 显式Intent：用于从Splash跳转到MainActivity，见**第5课（2025/09/30）— App导航**
  * 使用`finish()`管理返回栈：防止返回至Splash，见**第5课（2025/09/30）— App导航**

---

### ⏳ 任务3：保存与恢复状态（onSaveInstanceState/Bundle）
* **状态：** 进行中
* **描述：** 通过`onSaveInstanceState`和`Bundle`，在配置变更（如横竖屏切换）时保存/恢复关键变量状态。
* **应用概念：**
  * Activity状态持久化
  * Bundle与生命周期方法的配合
  * **第6课（2025/10/02）— 生命周期、状态与调试**

---

### 🔲 任务4：Single-Activity架构、Fragment与Navigation Component
* **状态：** 待办
* **描述：** 迁移为Fragment架构，配置Navigation Component，实现页面安全跳转与先进的返回栈管理。
* **计划概念：**
  * Fragment生命周期（`onCreate`、`onCreateView`、`onViewCreated`、`onDestroyView`）
  * Navigation Component（`nav_graph.xml`、action、Safe Args、popUpTo）
  * **第6课（2025/10/02）— Fragment与高级导航**

---

### 🔲 任务5：数据结构、布局与Adapter
* **状态：** 待办
* **计划概念：**
  * `data class`：建模宝可梦数据。见**第3课（2025/09/18）— 面向对象**
  * `ConstraintLayout`：构建列表项布局。见**第4课（2025/09/25）— 布局**
  * `RecyclerView`与`Adapter`：高效展示列表。
  * 高阶函数（Lambda）：处理列表项点击事件。
  * **第2课（2025/09/11）— 函数**

---

## 🛠 技术与库

* **语言：** Kotlin
* **架构：** MVVM（待实现）
* **Android Jetpack库：**
  * View Binding
  * Navigation Component（待实现）
  * ViewModel（待实现）
  * RecyclerView
* **网络：** Retrofit & Coroutines（待实现）
* **图片加载：** Coil/Glide（待实现）

---

## 备注

- [复查] 所有课堂笔记中标记“XXX”或存在疑问的点需在进入下一个Sprint前澄清。
- TODO：未来Sprint将集成API与自动化测试。
- 每次提交前务必确保App能编译、运行并正确输出日志。

---

## 课程/内容引用标准

- 引用格式：  
  **第X课（YYYY/MM/DD）— 主题**
- 有疑问的地方使用`[复查]`，并注明PDF或原笔记出处。
- 例：  
  `onSaveInstanceState：**第6课（2025/10/02）— 生命周期与状态持久化。** [复查]`
