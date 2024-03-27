package edu.quinnipiac.ser210.jobsearch

class JobsRepository {
    private val apiClient = ApiInterface.ApiClient

    suspend fun searchJobs(companyName: String, title: String?, location: String?): JobListResponse {
        return apiClient.searchJobs(companyName, title, location).execute().body()!!
    }
}