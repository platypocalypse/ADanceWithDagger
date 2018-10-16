package example.android.com.adancewithdagger.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.data.network.ApiService
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.launch
import java.lang.Exception
import javax.inject.Inject


class MainViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private var housesList: MutableLiveData<List<HouseDto>> = MutableLiveData()

    fun getHouses(): LiveData<List<HouseDto>> = housesList

    fun searchTextChanged(text: CharSequence) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = apiService.getHouses(text.toString()).await()
                if (response.isSuccessful) {
                    housesList.value = response.body()
                } else {
                    Log.e(MainViewModel::class.java.simpleName,response.errorBody()!!.string())
                }
            }
            catch (e: Exception) {
                Log.e(MainViewModel::class.java.simpleName, e.message)
            }
        }
    }
}
