import Versions.App

plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)
    kotlin(Plugins.KAPT)
    id(Plugins.HILT)
    id(Plugins.KOTLIN_PARCELIZE)
    id(Plugins.ANDROID_SAFEARGS)
}

android {
    compileSdk = App.COMPILE_SDK


    defaultConfig {
        applicationId = App.APP_NAME
        minSdk = App.MIN_SDK
        targetSdk = App.TARGET_SDK
        versionCode = App.VERSION_CODE
        versionName = App.VERSION_NAME
        testInstrumentationRunner = Testing.JUnitRunner
    }

    signingConfigs {
        create("release") {
            keyAlias = "MyKeyAlias"
            keyPassword = "MyKeyPassword"
            storeFile = file("Path/To/Key")
            storePassword = "KeyStorePassword"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "EXAMPLE", "\"release\"")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            buildConfigField("String", "EXAMPLE", "\"debug\"")
        }
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA
        targetCompatibility = Versions.JAVA
    }

    packagingOptions {
        resources.excludes.add("META-INF/*.kotlin_module")
        resources.excludes.add("META-INF/gradle-plugins")
    }

    kotlin.sourceSets.all {
        languageSettings.optIn("kotlin.RequiresOptIn")
    }

    buildFeatures.viewBinding = true
    buildFeatures.dataBinding = true
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = Versions.JAVA.toString()
        }
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(Dependencies.coil)
    implementation(Dependencies.daggerHilt)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.materialDesign)
    implementation(Lifecycle.viewModel)
    implementation(Moshi.moshi)
    implementation(Android.legacySup)
    implementation(Retrofit.moshiRetrofitConverter)
    implementation(Retrofit.retrofit)
    implementation(Coroutines.core)
    implementation(Coroutines.android)
    implementation(Android.appcompat)
    implementation(Android.activityKtx)
    implementation(Android.fragmentKtx)
    implementation(Android.coreKtx)
    implementation(Android.constraintLayout)
    implementation(Android.lottie)
    implementation(Android.coreSplash)
    implementation(Hilt.hiltAndroid)
    implementation(Room.common)
    implementation(Navigation.navFragment)
    implementation(Navigation.navUi)
    implementation(Room.ktx)
    implementation(Room.runtime)
    implementation(Gson.gson)
    implementation(Dependencies.glide)
    implementation(Hilt.hiltViewModel)
    kapt(Room.compiler)
    kapt(Moshi.codeGen)
    kapt(Hilt.daggerCompiler)
    testImplementation(Testing.jUnit)
    testImplementation(Testing.testCoroutines)
    testImplementation(Testing.testCoreKtx)
    testImplementation(Testing.testCore)
    testImplementation(Testing.truth)
    testImplementation(Testing.mockitoKotlin)
    testImplementation(Testing.turbine)

}
