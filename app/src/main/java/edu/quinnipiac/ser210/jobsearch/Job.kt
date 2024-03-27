package edu.quinnipiac.ser210.jobsearch

data class Job(

    val company_name: String,
    val formatted_relative_time: String,
    val id: String,
    val link: String,
    val locality: String,
    val location: String,
    val pub_date_ts_milli: Long,
    val salary: Salary?,
    val title: String
)
