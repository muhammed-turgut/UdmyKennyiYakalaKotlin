plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.muhammedturgut.kennyiyakalaudmykotlin"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.muhammedturgut.kennyiyakalaudmykotlin"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // AndroidX ve temel bağımlılıklar
    implementation(libs.androidx.core.ktx) // Kotlin için AndroidX Core uzantıları
    implementation(libs.androidx.appcompat) // Uyumlu eski API desteği
    implementation(libs.androidx.constraintlayout) // ConstraintLayout desteği
    implementation(libs.androidx.gridlayout) // GridLayout desteği

    // Material Design kütüphanesi
    implementation(libs.material)

    // Activity KTX (Lifecycle ile entegrasyon için)
    implementation(libs.androidx.activity)

    // Test kütüphaneleri
    testImplementation(libs.junit) // JUnit bağımsız birim testleri için
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit testleri
    androidTestImplementation(libs.androidx.espresso.core) // Espresso UI testi
}
