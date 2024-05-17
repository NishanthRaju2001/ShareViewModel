package abhishek.pathak.sharedviewmodeldemo.viewmodel

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class XYZ : ViewModel() {

    val userResponse = MutableLiveData<UserInfo>()

    fun fetchUserInfo(user: User) {
        // make your API call
        userResponse.value = UserInfo("", "")
    }
}

data class User(
    val email: String,
    val password: String
)

data class UserInfo(
    val userName: String,
    val userHobby: String
)

class MyActivity : AppCompatActivity() {

    private lateinit var xyz: XYZ

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        xyz = ViewModelProvider(this)[XYZ::class.java]

        xyz.fetchUserInfo(User("abc", "bcd"))
    }
}