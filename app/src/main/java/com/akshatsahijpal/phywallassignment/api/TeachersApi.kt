package com.akshatsahijpal.phywallassignment.api

import com.akshatsahijpal.phywallassignment.data.TeachersData
import retrofit2.http.GET

interface TeachersApi {
    @GET("easygautam/data/users")
    suspend fun getEveryTeacherDetails(): TeachersData
}