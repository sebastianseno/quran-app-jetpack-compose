package com.compose.quran.rest.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class SearchResult(
    @SerializedName("results")
    val images: List<UnsplashImage>,
)

data class UnsplashImage(
    val id: String,
    val urls: Urls,
    val likes: Int,
    val user: Userx
)

data class Urls(
    val regular: String
)
data class Userx(
    @SerializedName("links")
    val userLinks: UserLinks,
    val username: String
)

data class UserLinks(
    val html: String
)
