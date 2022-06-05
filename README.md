# bosta_task

## Overview
IN THIS SIMPLE TASK WE’RE EVALUATING YOUR CODING STYLE AND DESIGN PATTERNS.

## Requirements
The app is composed of 2 screens, first is the profile screen, it has the user name and address
pinned at the top and then it lists all of this user’s albums. You can get user albums by requesting
the albums endpoint and passing user id as a parameter.
When you press on any album it navigates to the second screen which is an album details screen.
You request the photos endpoint and pass album id as a parameter, then list the images in an
instagram-like grid. Also there should be a search bar that you can filter within the album by the
image title, when you start typing the screen should show only images that are related to this
search query.

## Software stack:
• Kotlin
• MVVM (Feel free to use your ownimplementation/vision)
• Android JetPack
• Retrofit 2
• Hilt dagger
• Coroutines
FEEL FREE TO USE ANY ADDITIONAL THIRD PARTY LIBRARIES.

## API Endpoints: • Base URL: https://jsonplaceholder.typicode.com
• User: GET /users you can pick any user to start with (preferably random)
• Albums: GET /albums (userId as a parameter)
• Photos: GET /photos (albumId as a parameter)

### Bonus Points:
Open any image in a separate image viewer with zooming and sharing functionality implemented

## Techniques :
* Kotlin
* Clean architecture
* Dagger with Hilt
* MVVM (Model,View,ViewModel)
* Kotlin Flow
* LiveData
* View Binding
* Lifecycle
* List Adapter

### Sources
* https://developer.android.com/jetpack/guide
* https://proandroiddev.com/android-error-handling-in-clean-architecture-844a7fc0dc03

## Photos
<img src="/Images/1.png" width=250 height=500  title=""> <img src="/Images/2.png" width=250 height=500 title="" > <img src="/Images/3.png" width=250 height=500  title="">
<img src="/Images/4.png" width=250 height=500 title=""> <img src="/Images/5.png" width=250 height=500 title="" > <img src="/Images/6.png" width=250 height=500  title="">