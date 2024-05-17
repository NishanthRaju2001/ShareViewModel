package abhishek.pathak.sharedviewmodeldemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _urlLiveData = MutableLiveData<String>()
    val urlLiveData :LiveData<String> get() = _urlLiveData

    fun updateUrl(url: String) = with(url) {
        _urlLiveData.value = this
    }

   /* fun updateUrl2(url: String) = urlLiveData.value == url

    fun updateUrl3(url: String) {
        urlLiveData.value = url
    }
    */
}