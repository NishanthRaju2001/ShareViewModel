package abhishek.pathak.sharedviewmodeldemo.view.fragments

import abhishek.pathak.sharedviewmodeldemo.databinding.FragmentUrlBinding
import abhishek.pathak.sharedviewmodeldemo.view.UrlAdapter
import abhishek.pathak.sharedviewmodeldemo.viewmodel.SharedViewModel
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UrlFragment : Fragment(), UrlAdapter.OnItemClickListener {

    private lateinit var binding: FragmentUrlBinding
    private lateinit var urls: ArrayList<String>
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        urls = ArrayList()
        with(urls) {
            add("https://www.google.com")
            add("https://www.facebook.com")
            add("https://www.gmail.com")
            add("https://www.youtube.com")
            add("https://www.twitter.com")
            add("https://www.github.com/myofficework000")
            add("https://www.linkdln.com/myofficework")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUrlBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerViewUrls
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        val adapter = UrlAdapter(urls, this)
        recyclerView.adapter = adapter

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }

    override fun onItemClick(url: String) {
        sharedViewModel.updateUrl(url)
    }
}