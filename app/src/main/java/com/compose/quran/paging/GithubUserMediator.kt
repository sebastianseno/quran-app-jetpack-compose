package com.compose.quran.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.compose.quran.rest.response.Item
import com.compose.quran.rest.services.SurahServices
import okio.IOException
import retrofit2.HttpException

class GithubUserMediator(
    private val surahServices: SurahServices
) : PagingSource<Int, Item>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        var pageIndex = params.key ?: 1
        return try {
            val response = surahServices.searchGithubUser(page = pageIndex)
            val endOfPaginationReached = response.items.isEmpty()
            if (response.items.isNotEmpty()) {
                LoadResult.Page(
                    data = response.items,
                    prevKey =  if (pageIndex == 1) null else pageIndex - 1,
                    nextKey = if (endOfPaginationReached) null else pageIndex + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (error: IOException) {
            return LoadResult.Error(error)
        } catch (error: HttpException) {
            return LoadResult.Error(error)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}