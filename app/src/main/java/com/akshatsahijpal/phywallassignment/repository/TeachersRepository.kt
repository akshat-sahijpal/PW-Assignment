package com.akshatsahijpal.phywallassignment.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.akshatsahijpal.phywallassignment.api.TeachersApi
import com.akshatsahijpal.phywallassignment.data.TeachersData
import com.akshatsahijpal.phywallassignment.source.TeachersPaginSource
import javax.inject.Inject

class TeachersRepository @Inject constructor(
    private var api: TeachersApi
) {
    fun getForBusinessData(): LiveData<PagingData<TeachersData.TeachersDataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 4,
                enablePlaceholders = true,
                initialLoadSize = 4,
                maxSize = 20
            ),
            pagingSourceFactory = {
                TeachersPaginSource(api)
            }
        ).liveData
    }
}