package edu.quinnipiac.ser210.jobsearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.quinnipiac.ser210.jobsearch.databinding.FragmentHomeBinding

class AllJobFragment : Fragment() {

    //variables for binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    class AllJobFragment : Fragment() {

        lateinit var recyclerView: RecyclerView
        lateinit var recyclerAdapter: RecyclerAdapter

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_all_job, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerAdapter = RecyclerAdapter(requireContext(), Navigation.findNavController(view))
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = recyclerAdapter
        }
    }
}