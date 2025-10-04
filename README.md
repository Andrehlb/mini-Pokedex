<p align="center">

<a href="README.en-US.md"><img src="https://img.shields.io/badge/🇺🇸%20English-en--US-blue?style=for-the-badge&logo=translate" alt="English" height="40"/></a>
<a href="README.zh-CN.md"><img src="https://img.shields.io/badge/🇨🇳%20简体中文-zh--CN-orange?style=for-the-badge&logo=translate" alt="简体中文" height="40"/></a>

</p>

---

# Mini-Pokedex (Android Nativo com Kotlin)

Um aplicativo simples de Pokédex para Android, desenvolvido em Kotlin como projeto final do curso Venturus Native Android. Possui telas de lista e detalhes, busca, filtro e consome a PokéAPI pública.

O projeto segue as melhores práticas de desenvolvimento Android, organizando etapas em Sprints, versionamento Git e documentação incremental dos aprendizados teóricos e práticos ao longo do curso.

---

## Development Log - Sprint 1: Fundação, Ciclo de Vida e Navegação Inicial

O objetivo desta Sprint é estabelecer a base arquitetural do app, dominar o ciclo de vida de Activities e Fragments, implementar navegação entre telas (Single-Activity/Fragment Architecture com Navigation Component) e garantir persistência de estado durante mudanças de configuração.

---

### ✅ Tarefa 0: Configuração do Ambiente e Projeto
* **Status:** Concluída
* **Sub-tarefas:**
  1. Criar repositório GitHub com `README.md`, `.gitignore` (Android) e `LICENSE` (MIT).
  2. Inicializar projeto Android Studio (Empty Views Activity).
  3. Habilitar View Binding em `build.gradle.kts`.
  4. Commit inicial da estrutura.
* **Referência:**  
  **Aula 4 (25/09/2025) — Construindo o 1º App / View Binding**
* **Resultado Esperado:**  
  Projeto compila, roda e estrutura inicial está versionada.

---

### ✅ Tarefa 1: Compreensão e Visualização do Ciclo de Vida da Activity
* **Status:** Concluída
* **Descrição:** Implementação de logs (`Log.d`) em todos os métodos do ciclo de vida (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`, `onRestart`) na `MainActivity`. Execução do app, análise dos logs no Logcat e uso do modo Debug para compreensão prática do ciclo de vida.
* **Conceitos Aplicados:**
  * Ciclo de vida de `Activity` no Android: métodos principais e suas chamadas, conforme **Aula 6 (02/10/2025) – Ciclo de Vida e Depuração**.

---

### ⏳ Tarefa 2: Implementação da `SplashActivity` e Navegação
* **Status:** Em andamento
* **Descrição:** Criação da tela de splash inicial, com temporizador para transição automática para a tela principal e gerenciamento correto do Back Stack.
* **Conceitos Aplicados:**
  * Criação de `Activity`: **Aula 4 (25/09/2025) - Construindo o 1º App**.
  * `Intent` Explícito: Para iniciar a `MainActivity` a partir da `SplashActivity`. Visto na **Aula 5 (30/09/2025) - App Navigation**.
  * Gerenciamento de `Back Stack` com `finish()`: Para impedir que o usuário retorne à Splash Screen. Visto na **Aula 5 (30/09/2025) - App Navigation**.

---

### ⏳ Tarefa 3: Salvando e Restaurando Estado (onSaveInstanceState/Bundle)
* **Status:** Em andamento
* **Descrição:** Implementar persistência de dados durante mudanças de configuração (por exemplo, ao girar a tela), usando `onSaveInstanceState` e `Bundle` para salvar/restaurar o estado de variáveis importantes.
* **Conceitos Aplicados:**
  * Persistência de estado em Activities.
  * Uso de Bundle e métodos do ciclo de vida para salvar/restaurar dados.
  * **Aula 6 (02/10/2025) – Ciclo de Vida, Estado e Debug**

---

### 🔲 Tarefa 4: Arquitetura Single-Activity, Fragments e Navigation Component
* **Status:** Pendente
* **Descrição:** Migrar a navegação para arquitetura baseada em Fragments, criar e configurar o Navigation Component, implementar navegação segura entre telas e controle avançado do Back Stack.
* **Conceitos Planejados:**
  * Ciclo de vida do Fragment (`onCreate`, `onCreateView`, `onViewCreated`, `onDestroyView`)
  * Uso do Navigation Component (`nav_graph.xml`, ações, Safe Args, popUpTo)
  * **Aula 6 (02/10/2025) – Fragments e Navegação Avançada**

---

### 🔲 Tarefa 5: Estrutura de Dados, Layouts e Adapter
* **Status:** Pendente
* **Conceitos Planejados:**
  * `data class`: Para modelar os dados de um Pokémon. Visto na **Aula 3 (18/09/2025) - POO**.
  * `ConstraintLayout`: Para construir o layout de cada item da lista. Visto na **Aula 4 (25/09/2025) - Layouts**.
  * `RecyclerView` e `Adapter`: Para exibir a lista de forma eficiente.
  * `Funções de Ordem Superior (Lambda)`: Para tratar eventos de clique em cada item.
  * **Aula 2 (11/09/2025) - Funções**

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

---

## Observações

- [REVISAR] Pontos marcados como “XXX” ou dúvidas nas anotações da aula devem ser esclarecidos antes de avançar para a próxima Sprint.
- TODO: Iniciar integração com API e testes instrumentados em Sprint futura.
- Sempre validar se o app compila, executa e loga corretamente antes de cada commit.

---

## Padronização de Referências de Aula/Conteúdo

- Cite sempre:  
  **Aula X (DD/MM/AAAA) – Tema**
- Marque dúvidas com `[REVISAR]` e referência ao PDF/anotação original.
- Exemplo:  
  `onSaveInstanceState: **Aula 6 (02/10/2025) – Ciclo de Vida e Persistência.** [REVISAR]`
