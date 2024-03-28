package edu.quinnipiac.ser210.jobsearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.quinnipiac.ser210.jobsearch.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    //variables for binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment, with binding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //making the spinner look nice
        val spinner: Spinner = binding.locations
        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.locations, // your string array resource
            android.R.layout.simple_spinner_item
        )
        // Specify the custom layout to use for each item
        adapter.setDropDownViewResource(R.layout.spinner_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter

        spinner.setOnClickListener {
            
        }


        //set all jobs on click
        val allbutton: Button = binding.allJobsButton
        allbutton.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToAllJobFragment2()
            findNavController().navigate(action)
        }

    }

}