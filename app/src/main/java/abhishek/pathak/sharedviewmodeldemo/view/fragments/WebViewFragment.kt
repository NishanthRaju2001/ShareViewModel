package abhishek.pathak.sharedviewmodeldemo.view.fragments

import abhishek.pathak.sharedviewmodeldemo.databinding.FragmentWebViewBinding
import abhishek.pathak.sharedviewmodeldemo.viewmodel.SharedViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebViewBinding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.webView) {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true

            sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
            sharedViewModel.urlLiveData.observe(viewLifecycleOwner) {
                loadUrl(it)
            }
        }
    }
}