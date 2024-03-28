package edu.quinnipiac.ser210.jobsearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.quinnipiac.ser210.jobsearch.homeFragmentDirections
import edu.quinnipiac.ser210.jobsearch.databinding.FragmentHomeBinding

class homeFragment : Fragment() {

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
        //on click listener for spinner and bringing you to location fragment
        val spinner: Spinner = binding.locations
        binding.locations.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){
                if (position > 0){
                    val selectedLocation = parent.getItemAtPosition(position).toString()
                    val locationAction = homeFragmentDirections.actionHomeFragmentToLocationFragment(selectedLocation)
                    findNavController().navigate(locationAction)

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
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


        //set all jobs on click
        val allbutton: Button = binding.allJobsButton
        allbutton.setOnClickListener {
            val action = homeFragmentDirections.actionHomeFragmentToAllJobFragment2()
            findNavController().navigate(action)
        }

    }
}