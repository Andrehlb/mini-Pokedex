# Mini-Pokedex (Android Nativo com Kotlin)

A simple Pokedex app for Android, built with Kotlin, as the final project for the Venturus Native Android course. It features list/detail screens, search/filter functionality, and consumes the public PokeAPI v2.

Este projeto está sendo desenvolvido seguindo as melhores práticas de mercado, incluindo um fluxo de trabalho baseado em Sprints e versionamento com Git, documentando a aplicação dos conceitos teóricos em cada etapa prática.

---

## Development Log - Sprint 1: Fundação e Navegação Inicial

O objetivo desta Sprint é estabelecer a arquitetura base do projeto e implementar o fluxo de navegação da tela de Splash para a tela de Lista.

### ✅ Tarefa 0: Configuração do Ambiente e Arquitetura Limpa
* **Status:** Concluída
* **Descrição:** Configuração do repositório Git, criação da estrutura do projeto Android e habilitação de ferramentas essenciais para um desenvolvimento limpo e seguro.
* **Conceitos Aplicados:**
    * [cite_start]`View Binding`: Habilitado no `build.gradle.kts` para substituir `findViewById()` e garantir acesso type-safe às views, conforme abordado na **Aula 4 (25/09/2025) - Construindo o 1º App / Views / Layouts**[cite: 401].

### ⏳ Tarefa 1: Implementação da `SplashActivity` e Navegação
* **Status:** Em andamento
* **Descrição:** Criação da tela de splash inicial, com temporizador para transição automática para a tela principal e gerenciamento correto do Back Stack.
* **Conceitos Aplicados:**
    * Criação de `Activity`: **Aula 4 (25/09/2025) - Construindo o 1º App**.
    * `Intent` Explícito: Para iniciar a `MainActivity` a partir da `SplashActivity`. [cite_start]Visto na **Aula 5 (30/09/2025) - App Navigation**[cite: 402].
    * Gerenciamento de `Back Stack` com `finish()`: Para impedir que o usuário retorne à Splash Screen. [cite_start]Visto na **Aula 5 (30/09/2025) - App Navigation**[cite: 402].

### 🔲 Tarefa 2: Estrutura de Dados (`data class`) e Layout do Item da Lista
* **Status:** Pendente
* **Conceitos Planejados:**
    * `data class`: Para modelar os dados de um Pokémon. [cite_start]Visto na **Aula 3 (18/09/2025) - POO**[cite: 400].
    * `ConstraintLayout`: Para construir o layout de cada item da lista. [cite_start]Visto na **Aula 4 (25/09/2025) - Layouts**[cite: 401].

### 🔲 Tarefa 3: Construção do `RecyclerView.Adapter`
* **Status:** Pendente
* **Conceitos Planejados:**
    * `RecyclerView` e `Adapter`: Para exibir a lista de forma eficiente. [cite_start]Visto na **Aula 4 (25/09/2025) - Layouts**[cite: 401].
    * `Funções de Ordem Superior (Lambda)`: Para tratar eventos de clique em cada item. [cite_start]Visto na **Aula 2 (11/09/2025) - Funções**[cite: 399].

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