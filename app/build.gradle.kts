import dev.roshana.buildsrc.BuildTypes
import dev.roshana.buildsrc.ConfigData
import dev.roshana.buildsrc.Dependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    buildTypes {
        getByName(BuildTypes.RELEASE) {
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    dependencies {
        implementation(Dependencies.ComposeLibs.coreKtx)

        /** compose
         **/
        implementation(Dependencies.ComposeLibs.composeUi)
        implementation(Dependencies.ComposeLibs.composeMaterial)
        implementation(Dependencies.ComposeLibs.composeUiPreview)
        implementation(Dependencies.ComposeLibs.androidxLifeCycle)
        implementation(Dependencies.ComposeLibs.composeActivity)

        /** hilt
         **/
        implementation(Dependencies.CommonLibs.hilt)
        kapt(Dependencies.CommonLibs.hiltCompiler)


        /** testing
         **/
        testImplementation(Dependencies.TestLibs.junit)
        androidTestImplementation(Dependencies.TestLibs.extJunit)
        androidTestImplementation(Dependencies.TestLibs.espresso)
        androidTestImplementation(Dependencies.TestLibs.composeUiJunit)
        debugImplementation(Dependencies.TestLibs.composeUiTooling)
        debugImplementation(Dependencies.TestLibs.composeUiTestManifest)
    }

}