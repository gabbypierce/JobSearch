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

class locationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

}