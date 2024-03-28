package edu.quinnipiac.ser210.jobsearch

import retrofit2.Call;
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface ApiInterface {

    @Headers(
        "X-RapidAPI-Host: indeed12.p.rapidapi.com",
        "X-RapidAPI-Key: 274d42e19cmsh3a6436ed8c04afbp1653f1jsn040500aa06cd"
    )
    @GET("jobs/search")
    suspend fun searchJobs(
        @Query("company_name") companyName: String,
        @Query("title") title: String?, // Optional, based on API capabilities
        @Query("location") location: String? // Optional, based on API capabilities
    ): Call<JobListResponse>

    object ApiClient {
        private val apiInterface: ApiInterface by lazy {
            Retrofit.Builder()
                .baseUrl("https://indeed12.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
        suspend fun searchJobs(companyName: String, title: String?, location: String?) = apiInterface.searchJobs(companyName, title, location)
    }

    companion object {

        var BASE_URL = "https://indeed12.p.rapidapi.com/"

        fun create() : ApiInterface {

            val logging = HttpLoggingInterceptor()
            // set your desired log level
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging) // <-- this is the important line!
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}