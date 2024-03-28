package edu.quinnipiac.ser210.jobsearch

import edu.quinnipiac.ser210.jobsearch.api.Hit

data class jobJSON(
    val count: Int,
    val hits: List<Hit>,
    val indeed_final_url: String,
    val next_page_id: Int,
    val suggest_locality: Any
)