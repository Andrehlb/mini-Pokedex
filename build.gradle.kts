// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
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
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    }
}
