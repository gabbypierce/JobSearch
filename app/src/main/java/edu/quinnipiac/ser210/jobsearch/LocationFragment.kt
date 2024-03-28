/*
  * Sam Woodburn & Gabby Pierce
  * SER210- assignment 3
  * location fragment where all jobs from a user specified location are shown
 */
package edu.quinnipiac.ser210.jobsearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LocationFragment : Fragment() {

    private lateinit var viewModel: JobsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val repository = JobsRepository() // Initialize your repository (if needed here)
        val factory = JobsViewModelFactory(repository)

        // Retrieve the ViewModel
        viewModel = ViewModelProvider(this, factory)[JobsViewModel::class.java]

        // Observe ViewModel LiveData
        viewModel.searchJobs("YourCompanyName", null, null).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Success<*> -> {
                    // Update UI with the fetched data
                    updateUI(result.data as JobListResponse)
                }
                is Result.Error -> {
                    // Handle error
                    Toast.makeText(context, "Error fetching data", Toast.LENGTH_SHORT).show()
                }
                Result.Loading -> {
                    // Show loading indicator
                }
            }
        })

        return inflater.inflate(R.layout.fragment_all_job, container, false)
    }

    private fun updateUI(jobList: JobListResponse) {
        val view = view ?: return
        // Assuming jobList.jobs[0] contains the data you want to display
        // Make sure to check if jobList.jobs is not empty to avoid IndexOutOfBoundsException
        if (jobList.jobs.isNotEmpty()) {
            val job = jobList.jobs[0] // Get the first job for demonstration
            view.findViewById<TextView>(R.id.tvCompanyName).text = "Company Name: ${job.company_name}"
            view.findViewById<TextView>(R.id.tvJobTitle).text = "Job Title: ${job.title}"
            view.findViewById<TextView>(R.id.tvLocation).text = "Location: ${job.location}"
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val location = arguments?.getString("location")

        // Assuming you have already initialized your viewModel in onCreateView or via property delegation

        // Now, observe the LiveData from the ViewModel.
        viewModel.searchJobs(location ?: "companyName", null, null).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    // Show loading indicator
                }
                is Result.Success -> {
                    // Update your UI with the data fetched
                    updateUI(result.data as JobListResponse)
                    // Use 'jobs' to update your UI
                }
                is Result.Error -> {
                    // Handle error, perhaps show a message or a retry button
                    Toast.makeText(context, "Error fetching data", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}
