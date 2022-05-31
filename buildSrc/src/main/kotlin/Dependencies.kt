object Testing {
    const val  JUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val  jUnit = "junit:junit:${Versions.Test.jUnit}"
    const val testCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.testCoroutines}"
    const val testCoreKtx = "androidx.test:core-ktx:${Versions.Test.testCoreKtx}"
    const val testCore = "androidx.test:core-ktx:${Versions.Test.testCore}"
    const val truth = "com.google.truth:truth:${Versions.Test.truth}"
    const val mockitoKotlin = "io.mockk:mockk:${Versions.Test.mockitoKotlin}"
    const val turbine = "app.cash.turbine:turbine:${Versions.Test.turbine}"
}

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.kotlinStdlib}"
    const val gradle = "com.android.tools.build:gradle:${Versions.GRADLE}"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt.daggerHiltPlugin}"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Kotlin.safeArgs}"
    const val materialDesign = "com.google.android.material:material:${Versions.Google.material}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val glide = "com.github.bumptech.glide:glide:4.12.0"
}


object Lifecycle {
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle.viewModel}"
}

object Hilt {
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Hilt.daggerCompiler}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.Hilt.hiltViewModel}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.Hilt.hiltAndroid}"
}

object Moshi {
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.Moshi.moshi}"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.Moshi.codeGen}"
}
object Gson {
    const val gson = "com.google.code.gson:gson:2.8.7"
}
object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}"
    const val moshiRetrofitConverter = "com.squareup.retrofit2:converter-moshi:${Versions.Retrofit.moshiRetrofitConverter}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines.core}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines.android}"
}

object Android {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompact}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.AndroidX.activityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.1"
    const val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.core}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraint}"
    const val lottie = "com.airbnb.android:lottie:${Versions.AndroidX.lottie}"
    const val coreSplash = "androidx.core:core-splashscreen:${Versions.AndroidX.coreSplash}"
    const val legacySup = "androidx.legacy:legacy-support-v4:1.0.0"
}

object Room {
    const val compiler = "androidx.room:room-compiler:${Versions.Room.compiler}"
    const val ktx = "androidx.room:room-ktx:${Versions.Room.ktx}"
    const val runtime = "androidx.room:room-runtime:${Versions.Room.runtime}"
    const val common = "androidx.room:room-common:2.4.2"
}

object Navigation {
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:2.3.1"
    const val navUi = "androidx.navigation:navigation-ui-ktx:2.3.1"
}

