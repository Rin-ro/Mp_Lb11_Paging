package com.example.mp_lb11_paging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mp_lb11_paging.data.model.Post
import com.example.mp_lb11_paging.data.remote.PostPagingSource
import com.example.mp_lb11_paging.data.remote.RetrofitClient
import kotlinx.coroutines.flow.Flow

object PostPagingProvider {
    private val api = RetrofitClient.postApi

    fun getPostsFlow(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PostPagingSource(api) }
        ).flow
    }
}