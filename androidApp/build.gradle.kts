plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp") version("1.8.10-1.0.9")
}

android {
    namespace = "com.ticonsys.taxcalculator.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.ticonsys.taxcalculator.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    val composeBom = platform("androidx.compose:compose-bom:2023.05.01")
    implementation(composeBom)

    implementation("androidx.activity:activity-compose:1.7.2")

    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-viewbinding")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material-icons-extended")


    implementation("androidx.compose.material:material")
//    implementation("androidx.compose.material3:material3")

    val composeDestination = "1.7.36-beta"
    implementation("io.github.raamcosta.compose-destinations:core:$composeDestination")
    ksp("io.github.raamcosta.compose-destinations:ksp:$composeDestination")

    implementation("com.google.accompanist:accompanist-pager:0.13.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.13.0")
}