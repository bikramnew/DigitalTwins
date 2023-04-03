# Digital Twins - Modern Android Architecture

Digital Twins is a sample project that provide users with a list of digital twins of their belongings.
It allow users to easily add or discard these digital twins via a minimalist and user-friendly interface. Also, the app allows to persist this data locally so that users can access it even after closing the app. 

This project presents a modern approach to Android app development. The project tries to combine popular Android tools and to demonstrate best development practices by utilizing up to date tech-stack like Compose, Kotlin Flow etc.

The sample app layers its presentation through MVVM presentation pattern. Additionally, the application features animations while displaying row items or other effects while swiping row items.

## Description

<img src="misc/demo_gif.gif" width="380" height="620" align="right" hspace="20">

* UI 
   * [Compose](https://developer.android.com/jetpack/compose) declarative UI framework
   * [Material design](https://material.io/design)

* Tech/Tools
    * [Kotlin](https://kotlinlang.org/) 100% coverage
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Flow](https://developer.android.com/kotlin/flow) for async operations
    * [Jetpack](https://developer.android.com/jetpack)
        * [Compose](https://developer.android.com/jetpack/compose) 
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that store/manage UI state
    
* Modern Architecture
    * Single activity architecture
    * MVVM for presentation layer
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel))
    * [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions

## Presentation patterns layers
* View - Composable screens that consume state, apply effects and delegate events upstream.
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that manages and set the state of the corresponding screen. The ViewModel is scoped to the lifetime of the corresponding screen composable in the backstack.
* Model - Data source classes for digital twins.
