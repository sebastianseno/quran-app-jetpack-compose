package com.compose.quran.rest.response

import android.os.Parcelable
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class UserResponse(
    @SerializedName("total_count")
    val totalCount: Int = 0,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean = false,
    @SerializedName("items")
    val items: List<Item> = listOf()
) : Parcelable

@Keep
@Parcelize
data class Item(
    @SerializedName("name")
    val login: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("node_id")
    val nodeId: String = "",
    @SerializedName("full_name")
    val fullName: String = "",
    @SerializedName("gravatar_id")
    val gravatarId: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("html_url")
    val htmlUrl: String = "",
    @SerializedName("followers_url")
    val followersUrl: String = "",
    @SerializedName("following_url")
    val followingUrl: String = "",
    @SerializedName("gists_url")
    val gistsUrl: String = "",
    @SerializedName("starred_url")
    val starredUrl: String = "",
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String = "",
    @SerializedName("organizations_url")
    val organizationsUrl: String = "",
    @SerializedName("repos_url")
    val reposUrl: String = "",
    @SerializedName("events_url")
    val eventsUrl: String = "",
    @SerializedName("received_events_url")
    val receivedEventsUrl: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("site_admin")
    val siteAdmin: Boolean = false,
    @SerializedName("score")
    val score: Double = 0.0
): Parcelable


fun Item.toUser(): User {
    return User(
        id, login, fullName
    )
}

data class User(
    val id: Int,
    val name: String,
    val imageUrl: String
)