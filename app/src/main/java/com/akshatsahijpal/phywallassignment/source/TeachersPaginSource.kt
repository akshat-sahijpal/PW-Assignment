package com.akshatsahijpal.phywallassignment.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.akshatsahijpal.phywallassignment.api.TeachersApi
import com.akshatsahijpal.phywallassignment.data.TeachersData

class TeachersPaginSource constructor(
    private var api: TeachersApi
) : PagingSource<Int, TeachersData.TeachersDataItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TeachersData.TeachersDataItem> {
        val currentPosition = params.key ?: 1
        return try {
            val data = api.getEveryTeacherDetails()
            val res = data.items
            LoadResult.Page(
                data = res,
                prevKey = if (currentPosition == 1) null else currentPosition - 1,
                nextKey = if (res.isEmpty()) null else currentPosition + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TeachersData.TeachersDataItem>): Int? {
        TODO("Not yet implemented")
    }
}