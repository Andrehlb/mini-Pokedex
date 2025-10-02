<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</div>

---

# Mini-Pokedex（原生 Android，Kotlin）

这是一个用 Kotlin 构建的简单 Android Pokedex 应用，作为 Venturus 原生 Android 课程的期末项目。它包含列表/详情页面、搜索/筛选功能，并使用公开的 PokéAPI。

本项目遵循业界最佳实践开发，包括基于 Sprints 的工作流和 Git 版本管理，记录理论知识在实践中的应用。

---

## 开发日志 - Sprint 1：基础与初始导航

本 Sprint 目标是建立项目的基础架构，并实现从启动页到列表页的导航流程。

### ✅ 任务 0：环境配置与 Clean Architecture
* **状态：** 已完成
* **描述：** 配置 Git 仓库，创建 Android 项目结构，并启用关键开发工具，保证开发过程的规范与安全。
* **应用概念：**
    * `View Binding`：在 `build.gradle.kts` 启用，用于替代 `findViewById()`，实现类型安全的视图访问，详见 **第4课（2025/09/25）- 构建第一个App / View Binding**。

### ⏳ 任务 1：实现 `SplashActivity` 与导航
* **状态：** 进行中
* **描述：** 创建启动页，设置定时器自动跳转到主页面，并正确管理返回栈。
* **应用概念：**
    * 创建 `Activity`：**第4课（2025/09/25）- 构建第一个App**。
    * 显式 `Intent`：用于从 `SplashActivity` 启动 `MainActivity`。详见 **第5课（2025/09/30）- App Navigation**。
    * 使用 `finish()` 管理返回栈：防止用户返回启动页。详见 **第5课（2025/09/30）- App Navigation**。

### 🔲 任务 2：数据结构（`data class`）与列表项布局
* **状态：** 待办
* **计划概念：**
    * `data class`：用于建模宝可梦数据。详见 **第3课（2025/09/18）- 面向对象编程**。
    * `ConstraintLayout`：用于构建每个列表项的布局。详见 **第4课（2025/09/25）- 布局**。

### 🔲 任务 3：构建 `RecyclerView.Adapter`
* **状态：** 待办
* **计划概念：**
    * `RecyclerView` 和 `Adapter`：高效展示列表。详见 **第4课（2025/09/25）- 布局**。
    * 高阶函数（Lambda）：处理每个列表项的点击事件。详见 **第2课（2025/09/11）- 函数**。

---

## 🛠 技术与库

* **语言：** Kotlin
* **架构：** MVVM（待实现）
* **Android Jetpack 库：**
    * View Binding
    * Navigation Component（待实现）
    * ViewModel（待实现）
    * RecyclerView
* **网络：** Retrofit & Coroutines（待实现）
* **图片：** Coil/Glide（待实现）
