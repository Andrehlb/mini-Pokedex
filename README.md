<p align="center">

<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</p>

---

# Mini-Pokedex (Android Nativo com Kotlin)

Um aplicativo simples de Pokédex para Android, desenvolvido em Kotlin como projeto final do curso Venturus Native Android. O projeto consome a PokéAPI pública e apresenta telas de lista e detalhes com busca, filtros, animações Lottie e off-line básico.

O projeto segue a arquitetura **MVVM** e melhores práticas, como Jetpack (ViewModel, LiveData, DataBinding, SplashScreen API, Room, WorkManager), coroutines, Retrofit, Lottie pra animações.

---

## Development Log - Sprints Atualizadas (baseado revisão 30/10/2025)

Objetivo: Mandatório (splash animado, lista RecyclerView + imagem/nome, busca/filtros tipos/gerações, detalhes nome/ID/imagem/tipos/altura/peso/stats) + extras viáveis (off-line sync, animação Pokébola, share social).

### Sprint 1: Fundação e Estrutura Visual (Concluída)
* **Descrição:** Base, splash moderna, layouts, navegação Intent.
* **Conceitos:** Ciclo vida, layouts Constraint/Recycler.

### Sprint 2: Camada UI e Estado Reativo (Em Andamento)
* **Descrição:** MVVM ViewModels, LiveData observers, RecyclerView fake data, coroutines fetch.
* **Conceitos:** Arquitetura UI, lambdas callbacks.

### Sprint 3: Persistência, Animações e UI Avançada (Próximo Foco)
* **Descrição:** Room DAO/Repo, Lottie Pokébola splash/loading, filtros/busca combinados, off-line cache.
* **Conceitos:** Room/WorkManager assíncrono, animações.

### Sprint 4: Camada Dados e Rede
* **Descrição:** Retrofit PokeAPI, sync Room, checar conexão.
* **Conceitos:** Rede coroutines.

### Sprint 5: Extras e Polimento (Opcional)
* **Descrição:** Selfie AR-lite (CameraX/Gemini), notificações WorkManager, share Intent, testes.
* **Conceitos:** Background tasks, IA APIs.

---

## 🛠 Tecnologias e Bibliotecas

* **Linguagem:** Kotlin
* **Arquitetura:** MVVM
* **Jetpack:** ViewModel/LiveData/DataBinding/SplashScreen/Room/Navigation/RecyclerView/WorkManager
* **Assincronicidade:** Coroutines
* **Rede:** Retrofit/Coil
* **Animações:** Lottie
* **Outros:** KSP (Room)

---