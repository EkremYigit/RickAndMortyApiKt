
## About
It loads **Rick & Morty characters** data from API and stores it in local storage. Characters data will be always loaded from local database. Remote data (from API) and Local data is always synchronized. 

# App Demo

![](https://github.com/EkremYigit/RickAndMortyApiKt/blob/master/project_gif.gif)

- Offline support. 
- Avoid boilerplate coding by using base classes with higher order functions.
- Clean architecture with MVVM (without uses-case)
- It supports dark theme.
- New Splash Screen API support
- Good animation experiences
- Caching first approaches with repository pattern.
- Kotlin dsl gradle support.

## Built With
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow & StateFlow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
  - [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
  - [DataBinding](https://developer.android.com/topic/libraries/data-binding)
  - [Room](https://developer.android.com/topic/libraries/architecture/room)
  - [SplashScreen](https://developer.android.com/guide/topics/ui/splash-screen)
  - [NavigationComponent](https://developer.android.com/guide/navigation/navigation-getting-started) - To manage single activity multiple fragment.
  - [SharedElementTransition](https://developer.android.com/guide/fragments/animate) - Motion effects and transformations to visually connect fragments during navigation
  - [Lottie](https://github.com/airbnb/lottie-android) - Animated loading dialog
- [Dependency Injection](https://developer.android.com/training/dependency-injection) - 
  - [Hilt-Dagger](https://dagger.dev/hilt/).
  - [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - DI for injecting `ViewModel`.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java.
- [Moshi Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/moshi) - A Converter which uses Moshi for serialization to and from JSON.
- [Glide](https://bumptech.github.io/glide/) - An image loading library
- [Material Components for Android](https://github.com/material-components/material-components-android)
- [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For writing Gradle build scripts using Kotlin.
