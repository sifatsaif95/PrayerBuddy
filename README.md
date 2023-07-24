# PrayerBuddy

# CLEAN Architecture with MVVM, Hilt, and Jetpack-Compose.

## About the app
I have created this small app to showcase my skills. On launching the app will show a screen with prayer times, location, and the Islamic date. My intention is also to make the app actually useful and publish it into the app store, so I am going to implement more functionalities in the future.

## Code structuring approach

1. MVVM separates composables from your business logic, it is good for testing purposes and also it keeps its state and data on configuration changes.

2. MVVM with Clean Architecture goes one step further in separating the responsibilities of your codebase on different layers. 

### CLEAN Architecture:

First of all the layers in CLEAN architecture have been separated into individual modules in a single Android project. It has a Domain layer, Data layer, and presentation layer, I created all the layers in the app module itself as my project was small, however, you can also have them in separate modules, and in that way, you can prevent accidental usage of classes in unintended places.


### Reason for using CLEAN architecture with MVVM

- Your code will be easily testable
- Your code will be further decoupled
- The project will be to maintain.
- Your team will be able to add new features more quickly.
- Inner layer module doesn't know about the outer layer, hence, outer data formats can’t be used in the inner layer
- Dependencies can only point inwards (from concretions towards abstractions)

## Libraries

- **Jetpack-Compose**: For view and design to give a modern look and feel.
- **Kotlin-Coroutine-Flow**:for asynchronous tasks, reactive programming, mapping, and transformation.
- **Hilt**: for Dependency Injection
- **Compose-Navigation**: for switching between screens
- **Retrofit**: Networking Library
- **ViewModel**: For persisting data across configuration changes
- **Expresso, Mockk, Junit** - For testing


## Technologies used
- MVVM
- Dagger-Hilt
- Clean Architecture
- ViewModel
- StateFlow
- Flow
- Coroutines
- Inline functions
- Compose
- Navigation
- Material3
- Repository
- Espresso
- JUnit


##App screenshots
<img width="339" alt="image" src="https://github.com/sifatsaif95/PrayerBuddy/assets/49454730/c4481377-8dc8-4646-b339-3a93ebee6d2c">

