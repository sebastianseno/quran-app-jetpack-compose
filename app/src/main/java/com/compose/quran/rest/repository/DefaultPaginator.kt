package com.compose.quran.rest.repository

import com.compose.quran.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class DefaultPaginator<Key, Item>(
    private val initialKey: Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> Flow<Resource<List<Item>>>,
    private inline val getNextKey: suspend (Flow<Resource<List<Item>>>) -> Key,
    private inline val onError: suspend (String?) -> Unit,
    private inline val onSuccess: suspend (items: List<Item>, newKey: Key) -> Unit
) : Paginator<Key, Item> {

    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {
        if (isMakingRequest) {
            return
        }
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false

        val itemsx = result.onEach {
            onError(it.message)
            onLoadUpdated(false)
            return@onEach
        }
        currentKey = getNextKey(itemsx)
        itemsx.onEach {
            onSuccess(
                it.data ?: emptyList(), currentKey
            )
        }

        onLoadUpdated(false)
    }

    override fun reset() {
        currentKey = initialKey
    }
}