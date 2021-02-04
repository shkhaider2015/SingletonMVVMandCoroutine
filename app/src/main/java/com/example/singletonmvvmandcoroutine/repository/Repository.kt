package com.example.singletonmvvmandcoroutine.repository

import androidx.lifecycle.LiveData
import com.example.singletonmvvmandcoroutine.Models.User
import com.example.singletonmvvmandcoroutine.api.RetrofitBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {

    var job: CompletableJob? = null

    fun getUser(userId : String) : LiveData<User>
    {
        job = Job()
        return object : LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let {
                    job -> CoroutineScope(IO + job)
                    .launch {
                        val user = RetrofitBuilder.apiService.getUser(userId)
                        withContext(Main){
                            value = user
                            job.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancellJobs()
    {
        job?.cancel()
    }
}