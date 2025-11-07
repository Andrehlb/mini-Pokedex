pluginManagement {
    repositories {
        maven {
            url = uri("https://mirrors.tencent.com/nexus/repository/maven-public/")
        }
        maven {
            url = uri("/usr/local/lib/android/sdk/extras/android/m2repository")
        }
        maven {
            url = uri("/usr/local/lib/android/sdk/extras/google/m2repository")
        }
        maven {
            url = uri("https://maven.google.com")
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://mirrors.tencent.com/nexus/repository/maven-public/")
        }
        maven {
            url = uri("/usr/local/lib/android/sdk/extras/android/m2repository")
        }
        maven {
            url = uri("/usr/local/lib/android/sdk/extras/google/m2repository")
        }
        maven {
            url = uri("https://maven.google.com")
        }
        mavenCentral()
    }
}

rootProject.name = "Mini Pokedex"
include(":app")
 