<p align="center">

<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</p>

---

# Mini-Pokedex (Android Nativo com Kotlin)

Um aplicativo simples de Pokédex para Android, desenvolvido em Kotlin como projeto final do curso Venturus Native Android. O projeto consome a PokéAPI pública e apresenta telas de lista e detalhes com busca.

O projeto segue a arquitetura **MVVM (Model-View-ViewModel)** e as melhores práticas de desenvolvimento Android, como o uso de componentes **Jetpack (ViewModel, LiveData, DataBinding, SplashScreen API)**, versionamento Git e documentação incremental.

---

## Development Log - Sprint 1: Arquitetura MVVM, Jetpack e UI Básica

O objetivo desta Sprint é estabelecer a base arquitetural do app usando MVVM, dominar o ciclo de vida e a persistência de estado com `ViewModel`, e construir a UI inicial com componentes modernos do Jetpack.

---

### ✅ Tarefa 0: Configuração do Ambiente e Projeto
* **Status:** Concluída
* **Descrição:** Configuração inicial do repositório no GitHub e do projeto no Android Studio com as dependências básicas.

---

### ✅ Tarefa 1: Compreensão e Visualização do Ciclo de Vida da Activity
* **Status:** Concluída
* **Descrição:** Implementação de logs (`Log.d`) em todos os métodos do ciclo de vida na `MainActivity` para análise e depuração do comportamento da Activity.

---

### ✅ Tarefa 2: Implementação da Splash Screen (Abordagem Moderna)
* **Status:** Concluída
* **Descrição:** Em vez de uma `SplashActivity` manual, foi utilizada a **`SplashScreen API`** do Jetpack. A configuração foi feita via `installSplashScreen()` na `MainActivity`, que gerencia a transição automaticamente. Isso elimina a necessidade de `Intent` explícito e gerenciamento de `Back Stack` com `finish()`.
* **Conceitos Aplicados:**
  * `SplashScreen API`: Biblioteca do Android Jetpack para uma tela de inicialização moderna e eficiente.

---

### ✅ Tarefa 3: Arquitetura MVVM com ViewModel e Data Binding
* **Status:** Concluída
* **Descrição:** A lógica foi movida da `MainActivity` para o `PokemonListViewModel`. O `ViewModel` agora é responsável por gerenciar os dados e o estado da UI. O `DataBinding` foi configurado para conectar o layout `activity_main.xml` diretamente ao `ViewModel`, permitindo que a UI reaja a mudanças de estado (como `isLoading`).
* **Conceitos Aplicados:**
  * **`ViewModel`**: Para gerenciar dados de UI e sobreviver a mudanças de configuração (substituindo o `onSaveInstanceState`).
  * **`DataBinding`**: Para vincular a UI (XML) à lógica de dados (ViewModel) de forma declarativa.
  * **`LiveData`**: Para criar fluxos de dados observáveis que a UI pode consumir.

---

### ⏳ Tarefa 4: Estrutura da UI com RecyclerView
* **Status:** Em andamento
* **Descrição:** O layout para um item individual da lista (`item_pokemon.xml`) foi criado usando `CardView` e `ConstraintLayout`. O próximo passo é adicionar o `RecyclerView` em `activity_main.xml` e criar o `PokemonAdapter` para gerenciar a exibição da lista de Pokémons.
* **Conceitos Aplicados/Planejados:**
  * `RecyclerView` e `Adapter`: Para exibir a lista de forma eficiente.
  * `ViewHolder`: Padrão para gerenciar as views de cada item.

---

### 🔲 Tarefa 5: Navegação e Camada de Dados
* **Status:** Pendente
* **Descrição:** Implementar a navegação da `MainActivity` para a `DetailActivity` ao clicar em um item da lista. Construir a camada de dados com `Repository` e `Retrofit` para consumir a PokéAPI.
* **Conceitos Planejados:**
  * `Repository Pattern`: Para gerenciar as fontes de dados (rede e cache local).
  * `Retrofit` e `Coroutines`: Para realizar as chamadas de rede de forma assíncrona.
  * `Intent` com `extras`: Para passar dados (como o ID do Pokémon) entre as Activities.

---

## 🛠 Tecnologias e Bibliotecas

* **Linguagem:** Kotlin
* **Arquitetura:** **MVVM (em implementação)**
* **Bibliotecas Android Jetpack:**
  * **ViewModel (Implementado)**
  * **DataBinding (Implementado)**
  * **SplashScreen API (Implementado)**
  * View Binding
  * RecyclerView (em implementação)
* **Rede:** Retrofit & Coroutines (a ser implementado)

---

## Observações

- O uso de `ViewModel` substitui a necessidade de salvar e restaurar estado manualmente com `onSaveInstanceState` e `Bundle` para dados complexos e de longa duração.
