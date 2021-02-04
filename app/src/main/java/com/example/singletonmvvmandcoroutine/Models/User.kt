package com.example.singletonmvvmandcoroutine.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("id")
    val id: String? = null,

    @Expose
    @SerializedName("title")
    val title: String? = null,

    @Expose
    @SerializedName("body")
    val body: String? = null,

    @Expose
    @SerializedName("userId")
    val userId: String? = null
){
    override fun toString(): String {
        return "Title : $title, Body : $body, userID : $userId "
    }
}