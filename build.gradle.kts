// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Usa 'alias' para buscar a versão do 'libs.versions.toml', sem conflito.
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
