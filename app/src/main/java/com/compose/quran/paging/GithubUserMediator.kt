package com.compose.quran.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.compose.quran.rest.response.UnsplashImage
import com.compose.quran.rest.services.SurahServices
import okio.IOException
import retrofit2.HttpException

class GithubUserMediator(
    private val surahServices: SurahServices
) : PagingSource<Int, UnsplashImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImage> {
        var pageIndex = params.key ?: 1
        return try {
            val response = surahServices.searchImages(query = "nature", perPage = 10)
            val endOfPaginationReached = response.images.isEmpty()
            if (response.images.isNotEmpty()) {
                LoadResult.Page(
                    data = response.images,
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

    override fun getRefreshKey(state: PagingState<Int, UnsplashImage>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}