package example.android.com.adancewithdagger.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.domain.GetHousesForTermUseCase
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import java.lang.Exception
import javax.inject.Inject


class MainViewModel
    @Inject constructor(private val getHousesForTermUseCase: GetHousesForTermUseCase) : ViewModel() {

    private var housesList: MutableLiveData<List<HouseDto>> = MutableLiveData()

    fun getHouses(): LiveData<List<HouseDto>> = housesList

    fun searchTextChanged(text: CharSequence) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val request = getHousesForTermUseCase.call(text.toString())
                val response = request.await()
                if (response.isSuccessful) {
                    housesList.postValue(response.body())
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
