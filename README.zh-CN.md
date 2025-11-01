<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>

</div>

---

# Mini-Pokedex (原生Android与Kotlin)

一个简单的安卓Pokedex应用，使用Kotlin开发，作为Venturus Native Android课程的最终项目。该项目使用公共的PokéAPI，并提供带有搜索、筛选、Lottie动画和基础离线功能的列表和详情页面。

项目遵循 **MVVM** 架构和最佳实践，例如Jetpack (ViewModel, LiveData, DataBinding, SplashScreen API, Room, WorkManager)、协程、Retrofit、Lottie动画。

---

## 开发日志 - 更新的Sprints (基于2025年10月30日审查)

目标：强制性 (动画闪屏, RecyclerView列表 + 图片/名称, 类型/世代搜索/筛选, 详情页名称/ID/图片/类型/身高/体重/统计数据) + 可行的额外功能 (离线同步, 精灵球动画, 社交分享)。

### Sprint 1: 基础和视觉结构 (已完成)
* **描述:** 基础, 现代化闪屏, 布局, Intent导航。
* **概念:** 生命周期, Constraint/Recycler布局。

### Sprint 2: UI层和响应式状态 (进行中)
* **描述:** MVVM ViewModels, LiveData观察者, RecyclerView假数据, 协程获取。
* **概念:** UI架构, lambda回调。

### Sprint 3: 持久化、动画和高级UI (下一个重点)
* **描述:** Room DAO/Repo, Lottie精灵球闪屏/加载, 组合筛选/搜索, 离线缓存。
* **概念:** 异步Room/WorkManager, 动画。

### Sprint 4: 数据层和网络
* **描述:** Retrofit PokeAPI, Room同步, 检查连接。
* **概念:** 协程网络。

### Sprint 5: 额外功能和润色 (可选)
* **描述:** AR-lite自拍 (CameraX/Gemini), WorkManager通知, 分享Intent, 测试。
* **概念:** 后台任务, AI API。

---

## 🛠 技术和库

* **语言:** Kotlin
* **架构:** MVVM
* **Jetpack:** ViewModel/LiveData/DataBinding/SplashScreen/Room/Navigation/RecyclerView/WorkManager
* **异步:** Coroutines
* **网络:** Retrofit/Coil
* **动画:** Lottie
* **其他:** KSP (Room)

---