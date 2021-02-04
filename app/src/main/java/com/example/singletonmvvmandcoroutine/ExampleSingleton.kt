package com.example.singletonmvvmandcoroutine

import com.example.singletonmvvmandcoroutine.Models.User

object ExampleSingleton {
    val singletonUser : User by lazy {
        User("1","myTitle", "myBody", "myUserid")
    }
}