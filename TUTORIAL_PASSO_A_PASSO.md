# Tutorial: Implementando a Tela de Detalhes do Pokemon - Passo a Passo

Olá! Este tutorial vai te guiar para implementar a tela de detalhes completa do Pokemon com stats, altura, peso e tipos. Vamos fazer juntos! 🎓

## 📋 O Que Vamos Implementar

A tela de detalhes vai mostrar:
- ✅ Imagem grande do Pokemon
- ✅ Nome e ID
- ✅ Tipos (ex: Grass, Poison)
- ✅ Altura e Peso
- ✅ Stats completos (HP, Attack, Defense, Sp.Atk, Sp.Def, Speed)

## 🎯 Passo 1: Estender o Model de Resposta da API

**Arquivo:** `app/src/main/java/br/com/venturus/andrehlb/minipokedex/model/PokemonDetailResponse.kt`

**O que fazer:**
1. Abra o arquivo `PokemonDetailResponse.kt`
2. Atualmente ele tem apenas `id`, `name` e `sprites`
3. Precisamos adicionar os campos que a API retorna

**Adicione estes campos ao data class `PokemonDetailResponse`:**
```kotlin
val height: Int,  // altura em decímetros
val weight: Int,  // peso em hectogramas
val stats: List<StatItem>,
val types: List<TypeItem>
```

**Crie estas novas data classes no mesmo arquivo:**
```kotlin
data class StatItem(
    @SerializedName("base_stat")
    val baseStat: Int,
    val stat: StatName
)

data class StatName(
    val name: String
)

data class TypeItem(
    val type: TypeName
)

data class TypeName(
    val name: String
)
```

**Por quê?**
- A API do Pokemon retorna os stats dentro de uma lista de objetos
- Cada stat tem um `base_stat` (valor) e um `stat.name` (nome do stat)
- Os tipos também vêm em uma estrutura aninhada
- O `@SerializedName` mapeia o nome do JSON para Kotlin

**Como testar:**
- Compile o projeto: não deve ter erros
- O Gson vai usar essas classes para parsear o JSON da API

---

## 🎯 Passo 2: Adicionar Endpoint na API

**Arquivo:** `app/src/main/java/br/com/venturus/andrehlb/minipokedex/network/PokeApiService.kt`

**O que fazer:**
Adicione este método na interface `PokeApiService`:

```kotlin
@GET("pokemon/{id}")
suspend fun getPokemonById(@Path("id") id: Int): PokemonDetailResponse
```

**Por quê?**
- Precisamos de um endpoint que busque Pokemon por ID
- O `@Path("id")` substitui `{id}` na URL
- Por exemplo: `/pokemon/1` vai buscar o Bulbasaur
- O `suspend` significa que é uma função assíncrona (coroutine)

**Como testar:**
- Compile o projeto: não deve ter erros
- Você pode testar a API manualmente: https://pokeapi.co/api/v2/pokemon/1

---

## 🎯 Passo 3: Atualizar o ViewModel

**Arquivo:** `app/src/main/java/br/com/venturus/andrehlb/minipokedex/viewmodel/DetailViewModel.kt`

**O que fazer:**

1. **Mudar o tipo do LiveData:**
   
   De:
   ```kotlin
   private val _pokemonDetail = MutableLiveData<Pokemon?>()
   val pokemonDetail: LiveData<Pokemon?> = _pokemonDetail
   ```
   
   Para:
   ```kotlin
   private val _pokemonDetail = MutableLiveData<PokemonDetailResponse?>()
   val pokemonDetail: LiveData<PokemonDetailResponse?> = _pokemonDetail
   ```

2. **Remover os métodos antigos:**
   - Remova `setPokemon()`, `showLoading()`, `hideLoading()`, `setError()`
   
3. **Adicionar imports:**
   ```kotlin
   import androidx.lifecycle.viewModelScope
   import br.com.venturus.andrehlb.minipokedex.model.PokemonDetailResponse
   import br.com.venturus.andrehlb.minipokedex.network.RetrofitClient
   import kotlinx.coroutines.launch
   ```

4. **Criar função para buscar dados:**
   ```kotlin
   fun fetchPokemonDetails(pokemonId: Int) {
       viewModelScope.launch {
           _isLoading.value = true
           _errorMessage.value = null
           
           try {
               val response = RetrofitClient.api.getPokemonById(pokemonId)
               _pokemonDetail.value = response
           } catch (e: Exception) {
               _errorMessage.value = "Erro ao carregar detalhes: ${e.message}"
               _pokemonDetail.value = null
           } finally {
               _isLoading.value = false
           }
       }
   }
   ```

**Por quê?**
- `viewModelScope.launch` cria uma coroutine para operação assíncrona
- `try-catch` trata erros de rede
- `_isLoading` controla o indicador de carregamento
- `_errorMessage` guarda mensagens de erro para exibir

**Como testar:**
- Compile o projeto
- Ainda não vai funcionar completamente (falta atualizar a Activity)

---

## 🎯 Passo 4: Atualizar a DetailActivity

**Arquivo:** `app/src/main/java/br/com/venturus/andrehlb/minipokedex/DetailActivity.kt`

**O que fazer:**

1. **Substituir todo o método `onCreate()` por:**

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
    binding.lifecycleOwner = this

    viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
    binding.viewModel = viewModel

    // Recupera Pokemon passado pela Intent
    val pokemon: Pokemon? = if (Build.VERSION.SDK_INT >= 33) {
        intent.getParcelableExtra("pokemon", Pokemon::class.java)
    } else {
        @Suppress("DEPRECATION")
        intent.getParcelableExtra("pokemon")
    }

    // Buscar dados detalhados da API
    pokemon?.let {
        viewModel.fetchPokemonDetails(it.id)
    }

    // Observer para os detalhes do Pokemon
    viewModel.pokemonDetail.observe(this) { pokemonDetail ->
        pokemonDetail?.let {
            binding.pokemonDetail = it
            binding.executePendingBindings()
        }
    }

    // Observer para estado de loading
    viewModel.isLoading.observe(this) { isLoading ->
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    // Observer para mensagens de erro
    viewModel.errorMessage.observe(this) { message ->
        message?.let {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}
```

2. **Adicionar imports necessários:**
```kotlin
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
```

**Por quê?**
- Os observers "escutam" mudanças no ViewModel
- Quando `pokemonDetail` muda, a UI atualiza automaticamente
- O binding conecta os dados aos views do XML
- `executePendingBindings()` força atualização imediata

**Como testar:**
- Compile
- Ainda não vai funcionar (falta o layout)

---

## 🎯 Passo 5: Adicionar Strings

**Arquivo:** `app/src/main/res/values/strings.xml`

**O que fazer:**
Adicione estas strings antes do `</resources>`:

```xml
<string name="pokemon_height">Altura: %1$.1f m</string>
<string name="pokemon_weight">Peso: %1$.1f kg</string>
<string name="pokemon_stats_title">Stats</string>
<string name="pokemon_hp">HP</string>
<string name="pokemon_attack">Attack</string>
<string name="pokemon_defense">Defense</string>
<string name="pokemon_special_attack">Sp. Atk</string>
<string name="pokemon_special_defense">Sp. Def</string>
<string name="pokemon_speed">Speed</string>
<string name="pokemon_type_title">Tipos</string>
```

**Por quê?**
- Boa prática: não colocar textos direto no XML
- Facilita tradução para outros idiomas
- O `%1$.1f` é um placeholder para números decimais

---

## 🎯 Passo 6: Criar Binding Adapters

**Arquivo:** `app/src/main/java/br/com/venturus/andrehlb/minipokedex/utils/BindingAdapters.kt`

**O que fazer:**
Adicione estas funções no arquivo (depois da função `loadImage` existente):

```kotlin
import android.widget.TextView
import br.com.venturus.andrehlb.minipokedex.model.PokemonDetailResponse

@BindingAdapter("pokemonTypes")
fun setPokemonTypes(view: TextView, pokemonDetail: PokemonDetailResponse?) {
    pokemonDetail?.let {
        val types = it.types.joinToString(", ") { type ->
            type.type.name.replaceFirstChar { char ->
                if (char.isLowerCase()) char.titlecase() else char.toString()
            }
        }
        view.text = types
    }
}

@BindingAdapter("pokemonHeight")
fun setPokemonHeight(view: TextView, height: Int?) {
    height?.let {
        // Altura vem em decímetros, converter para metros
        val heightInMeters = it / 10.0
        view.text = String.format("%.1f m", heightInMeters)
    }
}

@BindingAdapter("pokemonWeight")
fun setPokemonWeight(view: TextView, weight: Int?) {
    weight?.let {
        // Peso vem em hectogramas, converter para kg
        val weightInKg = it / 10.0
        view.text = String.format("%.1f kg", weightInKg)
    }
}

@BindingAdapter("pokemonStat")
fun setPokemonStat(view: TextView, pokemonDetail: PokemonDetailResponse?) {
    val statName = view.tag as? String ?: return
    pokemonDetail?.let {
        val stat = it.stats.find { statItem ->
            statItem.stat.name == statName
        }
        view.text = stat?.baseStat?.toString() ?: "0"
    }
}
```

**Por quê?**
- Binding Adapters são funções que o Data Binding chama automaticamente
- `pokemonTypes`: junta os tipos e capitaliza (grass → Grass)
- `pokemonHeight/Weight`: converte unidades (API usa decímetros e hectogramas)
- `pokemonStat`: busca um stat específico pelo nome usando a tag do view
- `replaceFirstChar` é o substituto moderno do `capitalize()` deprecated

**Como funcionam:**
- No XML você usa `app:pokemonTypes="@{pokemonDetail}"`
- O Data Binding chama automaticamente a função correspondente
- A função recebe o view e o valor e atualiza o texto

---

## 🎯 Passo 7: Atualizar o Layout

**Arquivo:** `app/src/main/res/layout/activity_detail.xml`

**O que fazer:**
Este é o passo mais longo. Substitua todo o conteúdo do arquivo por:

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="viewModel"
            type="br.com.venturus.andrehlb.minipokedex.viewmodel.DetailViewModel" />
        <variable
            name="pokemonDetail"
            type="br.com.venturus.andrehlb.minipokedex.model.PokemonDetailResponse" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="16dp"
        tools:context=".DetailActivity">

        <ScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintBottom_toBottomOf="parent">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:gravity="center_horizontal">

                <!-- Imagem do Pokemon -->
                <ImageView
                    android:id="@+id/pokemon_image"
                    android:layout_width="200dp"
                    android:layout_height="200dp"
                    android:contentDescription="@string/pokemon_image_description"
                    android:src="@drawable/placeholder_image"
                    android:layout_marginTop="16dp"
                    app:imageUrl="@{pokemonDetail.sprites.frontDefault}" />

                <!-- Nome do Pokemon -->
                <TextView
                    android:id="@+id/pokemon_name"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="32sp"
                    android:textStyle="bold"
                    android:textAllCaps="true"
                    android:layout_marginTop="16dp"
                    android:text="@{pokemonDetail.name}"
                    tools:text="Bulbasaur" />

                <!-- ID do Pokemon -->
                <TextView
                    android:id="@+id/pokemon_id"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="18sp"
                    android:layout_marginTop="4dp"
                    android:text="@{@string/pokemon_details_id(pokemonDetail.id)}"
                    tools:text="ID: 1" />

                <!-- Seção de Tipos -->
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/pokemon_type_title"
                    android:textSize="20sp"
                    android:textStyle="bold"
                    android:layout_marginTop="24dp" />

                <TextView
                    android:id="@+id/pokemon_types"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="16sp"
                    android:layout_marginTop="8dp"
                    app:pokemonTypes="@{pokemonDetail}"
                    tools:text="Grass, Poison" />

                <!-- Altura e Peso -->
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal"
                    android:gravity="center"
                    android:layout_marginTop="24dp">

                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:orientation="vertical"
                        android:gravity="center">

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="Altura"
                            android:textSize="16sp"
                            android:textStyle="bold" />

                        <TextView
                            android:id="@+id/pokemon_height"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:textSize="18sp"
                            android:layout_marginTop="4dp"
                            app:pokemonHeight="@{pokemonDetail.height}"
                            tools:text="0.7 m" />
                    </LinearLayout>

                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:orientation="vertical"
                        android:gravity="center">

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="Peso"
                            android:textSize="16sp"
                            android:textStyle="bold" />

                        <TextView
                            android:id="@+id/pokemon_weight"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:textSize="18sp"
                            android:layout_marginTop="4dp"
                            app:pokemonWeight="@{pokemonDetail.weight}"
                            tools:text="6.9 kg" />
                    </LinearLayout>
                </LinearLayout>

                <!-- Seção de Stats -->
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="@string/pokemon_stats_title"
                    android:textSize="20sp"
                    android:textStyle="bold"
                    android:layout_marginTop="24dp" />

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="vertical"
                    android:layout_marginTop="12dp"
                    android:paddingStart="16dp"
                    android:paddingEnd="16dp">

                    <!-- HP -->
                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:gravity="center_vertical"
                        android:layout_marginTop="8dp">

                        <TextView
                            android:layout_width="100dp"
                            android:layout_height="wrap_content"
                            android:text="@string/pokemon_hp"
                            android:textSize="16sp" />

                        <TextView
                            android:id="@+id/stat_hp_value"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:textSize="16sp"
                            android:textStyle="bold"
                            android:tag="hp"
                            app:pokemonStat="@{pokemonDetail}"
                            tools:text="45" />
                    </LinearLayout>

                    <!-- Attack -->
                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:gravity="center_vertical"
                        android:layout_marginTop="8dp">

                        <TextView
                            android:layout_width="100dp"
                            android:layout_height="wrap_content"
                            android:text="@string/pokemon_attack"
                            android:textSize="16sp" />

                        <TextView
                            android:id="@+id/stat_attack_value"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:textSize="16sp"
                            android:textStyle="bold"
                            android:tag="attack"
                            app:pokemonStat="@{pokemonDetail}"
                            tools:text="49" />
                    </LinearLayout>

                    <!-- Defense -->
                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:gravity="center_vertical"
                        android:layout_marginTop="8dp">

                        <TextView
                            android:layout_width="100dp"
                            android:layout_height="wrap_content"
                            android:text="@string/pokemon_defense"
                            android:textSize="16sp" />

                        <TextView
                            android:id="@+id/stat_defense_value"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:textSize="16sp"
                            android:textStyle="bold"
                            android:tag="defense"
                            app:pokemonStat="@{pokemonDetail}"
                            tools:text="49" />
                    </LinearLayout>

                    <!-- Special Attack -->
                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:gravity="center_vertical"
                        android:layout_marginTop="8dp">

                        <TextView
                            android:layout_width="100dp"
                            android:layout_height="wrap_content"
                            android:text="@string/pokemon_special_attack"
                            android:textSize="16sp" />

                        <TextView
                            android:id="@+id/stat_special_attack_value"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:textSize="16sp"
                            android:textStyle="bold"
                            android:tag="special-attack"
                            app:pokemonStat="@{pokemonDetail}"
                            tools:text="65" />
                    </LinearLayout>

                    <!-- Special Defense -->
                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:gravity="center_vertical"
                        android:layout_marginTop="8dp">

                        <TextView
                            android:layout_width="100dp"
                            android:layout_height="wrap_content"
                            android:text="@string/pokemon_special_defense"
                            android:textSize="16sp" />

                        <TextView
                            android:id="@+id/stat_special_defense_value"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:textSize="16sp"
                            android:textStyle="bold"
                            android:tag="special-defense"
                            app:pokemonStat="@{pokemonDetail}"
                            tools:text="65" />
                    </LinearLayout>

                    <!-- Speed -->
                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:gravity="center_vertical"
                        android:layout_marginTop="8dp"
                        android:layout_marginBottom="32dp">

                        <TextView
                            android:layout_width="100dp"
                            android:layout_height="wrap_content"
                            android:text="@string/pokemon_speed"
                            android:textSize="16sp" />

                        <TextView
                            android:id="@+id/stat_speed_value"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:textSize="16sp"
                            android:textStyle="bold"
                            android:tag="speed"
                            app:pokemonStat="@{pokemonDetail}"
                            tools:text="45" />
                    </LinearLayout>
                </LinearLayout>

            </LinearLayout>
        </ScrollView>

        <!-- Progress Bar -->
        <ProgressBar
            android:id="@+id/progress_bar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:visibility="gone"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

**Estrutura do Layout:**
- `<layout>` wrapper: necessário para Data Binding
- `<data>`: declara variáveis que vêm do código
- `ScrollView`: permite rolar se o conteúdo não couber
- `LinearLayout` vertical: organiza os elementos de cima para baixo
- Cada seção tem título e conteúdo
- `app:pokemonTypes`, `app:pokemonHeight`, etc: chamam os Binding Adapters
- `android:tag="hp"`: usada pelo Binding Adapter para identificar qual stat buscar
- `tools:text`: apenas para preview no Android Studio

**Destaques importantes:**
- `app:imageUrl="@{pokemonDetail.sprites.frontDefault}"`: carrega imagem
- `android:text="@{pokemonDetail.name}"`: binding direto com data binding
- `app:pokemonTypes="@{pokemonDetail}"`: chama função custom
- `android:tag="hp"` + `app:pokemonStat`: binding adapter sabe qual stat buscar

---

## 🎉 Testando!

Agora que tudo está implementado:

1. **Compile o projeto:**
   ```bash
   ./gradlew assembleDebug
   ```

2. **Instale no dispositivo/emulador:**
   ```bash
   ./gradlew installDebug
   ```

3. **Teste:**
   - Abra o app
   - Toque em um Pokemon da lista
   - Você deve ver todos os detalhes!

**Teste com estes Pokemon:**
- Bulbasaur (#1): Grass/Poison, 0.7m, 6.9kg
- Pikachu (#25): Electric, 0.4m, 6.0kg
- Charizard (#6): Fire/Flying, 1.7m, 90.5kg

---

## 🔍 Como Funciona (Resumo do Fluxo)

1. **MainActivity** → Usuário toca em Pokemon → Intent com Pokemon object
2. **DetailActivity** → Recebe Pokemon → Pega o ID
3. **DetailViewModel** → `fetchPokemonDetails(id)` → Chama API
4. **API (Retrofit)** → `getPokemonById(id)` → Busca dados
5. **JSON Parser (Gson)** → Converte JSON → `PokemonDetailResponse`
6. **ViewModel** → Atualiza `pokemonDetail` LiveData
7. **Activity Observer** → Detecta mudança → Atualiza `binding.pokemonDetail`
8. **Data Binding** → Chama Binding Adapters → Atualiza TextViews
9. **UI** → Mostra informações completas! ✨

---

## 🐛 Dicas de Debug

**Se não compilar:**
- Verifique os imports
- Clean & Rebuild: `./gradlew clean assembleDebug`

**Se crashar ao abrir detalhes:**
- Verifique Logcat no Android Studio
- Procure por exceptions
- Teste a API manualmente: https://pokeapi.co/api/v2/pokemon/1

**Se dados não aparecerem:**
- Verifique conexão com internet
- Veja se os observers estão registrados
- Adicione logs: `Log.d("TAG", "pokemonDetail: $it")`

**Se imagens não carregarem:**
- Verifique se a URL da imagem é válida
- Teste abrindo a URL no navegador
- Verifique se Coil está instalado

---

## 📚 Conceitos Aprendidos

- ✅ **Data Classes**: Estruturas de dados imutáveis
- ✅ **Retrofit**: Cliente HTTP para APIs REST
- ✅ **Coroutines**: Programação assíncrona em Kotlin
- ✅ **LiveData**: Dados observáveis lifecycle-aware
- ✅ **ViewModel**: Gerencia dados da UI
- ✅ **Data Binding**: Liga XML ao código
- ✅ **Binding Adapters**: Lógica custom de binding
- ✅ **MVVM**: Model-View-ViewModel architecture

---

## 🎯 Próximos Desafios

Agora que você implementou tudo, tente:
1. Adicionar barras de progresso para os stats
2. Colorir os tipos (Fire=vermelho, Water=azul)
3. Adicionar animações nas transições
4. Mostrar mais informações (abilities, evolutions)
5. Implementar cache offline

---

## 🎓 Parabéns!

Você implementou uma tela de detalhes completa com:
- Integração de API REST
- Arquitetura MVVM
- Data Binding
- Tratamento de erros
- UI responsiva

Continue praticando e explorando! 🚀

---

**Dúvidas?** Consulte os arquivos de referência que foram mantidos no repositório!
