<div align="center">

<a href="README.md"><img src="https://img.shields.io/badge/🌎%20Português%20(Brasil)-primary?style=for-the-badge&logo=translate" alt="Português (Brasil)" height="40"/></a>
<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</div>

---

# Mini-Pokedex (Android Nativo com Kotlin)

A simple Pokedex app for Android, built with Kotlin, as the final project for the Venturus Native Android course. It features list/detail screens, search/filter functionality, and consumes the public [...]

Este projeto está sendo desenvolvido seguindo as melhores práticas de mercado, incluindo um fluxo de trabalho baseado em Sprints e versionamento com Git, documentando a aplicação dos conceitos te�[...]

---

## Development Log - Sprint 1: Fundação e Navegação Inicial

O objetivo desta Sprint é estabelecer a arquitetura base do projeto e implementar o fluxo de navegação da tela de Splash para a tela de Lista.

### ✅ Tarefa 0: Configuração do Ambiente e Arquitetura Limpa
* **Status:** Concluída
* **Descrição:** Configuração do repositório Git, criação da estrutura do projeto Android e habilitação de ferramentas essenciais para um desenvolvimento limpo e seguro.
* **Conceitos Aplicados:**
  * `View Binding`: Habilitado no `build.gradle.kts` para substituir `findViewById()` e garantir acesso type-safe às views, conforme abordado na **Aula 4 (25/09/2025) - Construindo o 1º App / View[...]

### ⏳ Tarefa 1: Implementação da `SplashActivity` e Navegação
* **Status:** Em andamento
* **Descrição:** Criação da tela de splash inicial, com temporizador para transição automática para a tela principal e gerenciamento correto do Back Stack.
* **Conceitos Aplicados:**
  * Criação de `Activity`: **Aula 4 (25/09/2025) - Construindo o 1º App**.
  * `Intent` Explícito: Para iniciar a `MainActivity` a partir da `SplashActivity`. Visto na **Aula 5 (30/09/2025) - App Navigation**.
  * Gerenciamento de `Back Stack` com `finish()`: Para impedir que o usuário retorne à Splash Screen. Visto na **Aula 5 (30/09/2025) - App Navigation**.

### 🔲 Tarefa 2: Estrutura de Dados (`data class`) e Layout do Item da Lista
* **Status:** Pendente
* **Conceitos Planejados:**
  * `data class`: Para modelar os dados de um Pokémon. Visto na **Aula 3 (18/09/2025) - POO**.
  * `ConstraintLayout`: Para construir o layout de cada item da lista. Visto na **Aula 4 (25/09/2025) - Layouts**.

### 🔲 Tarefa 3: Construção do `RecyclerView.Adapter`
* **Status:** Pendente
* **Conceitos Planejados:**
  * `RecyclerView` e `Adapter`: Para exibir a lista de forma eficiente. Visto na **Aula 4 (25/09/2025) - Layouts**.
  * `Funções de Ordem Superior (Lambda)`: Para tratar eventos de clique em cada item. Visto na **Aula 2 (11/09/2025) - Funções**.

---

## 🛠 Tecnologias e Bibliotecas

* **Linguagem:** Kotlin
* **Arquitetura:** MVVM (a ser implementado)
* **Bibliotecas Android Jetpack:**
  * View Binding
  * Navigation Component (a ser implementado)
  * ViewModel (a ser implementado)
  * RecyclerView
* **Rede:** Retrofit & Coroutines (a ser implementado)
* **Imagens:** Coil/Glide (a ser implementado)
