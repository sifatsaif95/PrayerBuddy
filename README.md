# PrayerBuddy

# CLEAN Architecture with MVVM, Hilt and Jetpack-Compose.

## About the app
I have created this small app to showcase my skills. On launching the app will show a screen with prayer times, location and the islamic date. My intention is also to make the app actualy useful and publish into app store, so I am going to implement more functionalities in future.

## Code structuring approach

1. MVVM separates composables from your business logic, it is good for testing purposes and also it keeps it state and data on configuration changes.

2. MVVM with Clean Architecture goes one step further in separating the responsibilities of your code base on different layers. 

### CLEAN Architecture:

First of all the layers in CLEAN architecture has been separated into individual modules in a single Android project. It has Domain layer, Data layer and Presentaation layer, I created all the layers in app module itself as my project was small, however, you can also have them in separate modules and in that way you can prevent accidental usage of classes in unintended places.


### Reason for using CLEAN architecture with MVVM

- Your code will be easily testable
- Your code will be further decoupled
- The project will be to maintain.
- Your team will be able to add new features more quickly.
- Inner layer module dont know about outer layer, hence, outer data formats can’t be used in inner layer
- Dependencies can only point inwards (from concretions towards abstractions)

## Libraries

- **Jetpack-Compose**: For view and design to give modern looks and feel.
- **Kotlin-Coroutine-Flow**:for asynchronous task, reactive programming, mapping, transformation.
- **Hilt**: for Dependency Injection
- **Compose-Navigation**: for switching between screens
- **Retrofit**: Netwoking Library
- **ViewModel**: For persisting data across configuration changes
- **Expresso, Mockk, Junit** - For testing
