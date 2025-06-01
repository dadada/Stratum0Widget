plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
    id("kotlin-kapt")
    alias(libs.plugins.google.services)
}

android {
    namespace = "horse.amazin.my.stratum0.statuswidget"

    compileSdk = 35

    defaultConfig {
        applicationId = "horse.amazin.my.stratum0.statuswidget"

        minSdk = 23
        targetSdk = 33
        versionCode = 28
        versionName = "8.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".debug"
        }
    }
    flavorDimensions += "freedom"
    productFlavors {
        create("foss") {
            dimension = "freedom"
            versionNameSuffix = "-foss"
        }
        create("fcm") {
            dimension = "freedom"
            versionNameSuffix = "-play"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            // bcprov
            excludes += "META-INF/versions/9/OSGI-INF/MANIFEST.MF"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.okhttp)
    implementation(libs.sshj)
    implementation(libs.timber)
    implementation(libs.paperparcel)
    implementation(libs.paperparcel.kotlin)
    implementation(libs.bcprov.jdk18on)
    "kapt"(libs.paperparcel.compiler)
    "fcmImplementation"(libs.firebase.messaging)
}
