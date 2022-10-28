package com.compose.quran.rest.repository

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}