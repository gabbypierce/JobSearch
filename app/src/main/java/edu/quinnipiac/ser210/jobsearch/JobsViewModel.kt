package edu.quinnipiac.ser210.jobsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers


class JobsViewModel (private val repository: JobsRepository) : ViewModel() {
    fun searchJobs(companyName: String, title: String?, location: String?) = liveData(Dispatchers.IO) {
        emit(Result.Loading)
        try {
            val response = repository.searchJobs(companyName, title, location)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}