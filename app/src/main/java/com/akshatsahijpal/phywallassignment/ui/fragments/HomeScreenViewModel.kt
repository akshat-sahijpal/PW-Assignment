package com.akshatsahijpal.phywallassignment.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.phywallassignment.data.TeachersData
import com.akshatsahijpal.phywallassignment.repository.TeachersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private var repo: TeachersRepository
) : ViewModel() {
    fun getRefinedData(): LiveData<PagingData<TeachersData.TeachersDataItem>> {
        return repo.getForBusinessData().cachedIn(viewModelScope)
    }
}