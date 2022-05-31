import org.gradle.api.JavaVersion

object Versions {
    object App {
        const val APP_NAME = "com.ProjectTemplate"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0.0"
        const val MIN_SDK = 21
        const val TARGET_SDK = 30
        const val COMPILE_SDK = 31
    }

    object Test {
        const val jUnit = "4.1.2"
        const val truth = "1.1.2"
        const val mockitoKotlin = "1.10.6"
        const val turbine = "0.7.0"
        const val testCoroutines = "1.6.0"
        const val testCoreKtx = "1.4.0"
        const val testCore = "1.4.0"
    }

    object Google {
        const val material = "1.5.0"
    }

    object AndroidX {
        const val core = "1.7.0"
        const val appcompact = "1.4.1"
        const val constraint = "2.1.3"
        const val activityKtx = "1.1.0"
        const val lottie = "5.0.3"
        const val coreSplash = "1.0.0-beta01"
    }


    object Kotlin {
        const val kotlinStdlib = "1.5.21"
        const val kotlinGradle = "1.6.21"
        const val safeArgs = "2.3.1"

    }

    object Lifecycle {
        const val viewModel = "2.2.0"
    }

    object Hilt {
        const val daggerCompiler = "2.38.1"
        const val hiltCompiler = "1.0.0-alpha02"
        const val hiltViewModel = "1.0.0-alpha02"
        const val hiltAndroid = "2.38.1"
        const val daggerHiltPlugin = "2.38.1"

    }

    object Moshi {
        const val moshi = "1.11.0"
        const val codeGen = "1.11.0"
    }

    object Retrofit {
        const val retrofit = "2.9.0"
        const val moshiRetrofitConverter = "2.9.0"
    }

    object Coroutines {
        const val core = "1.4.2"
        const val android = "1.4.2"
    }

    object Room {
        const val compiler = "2.4.2"
        const val ktx = "2.4.2"
        const val runtime = "2.4.2"
    }

    const val GRADLE = "7.1.2"

    const val coil = "1.0.0"
    val JAVA = JavaVersion.VERSION_11
}
