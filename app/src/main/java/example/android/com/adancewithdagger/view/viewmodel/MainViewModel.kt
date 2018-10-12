package example.android.com.adancewithdagger.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.android.com.adancewithdagger.data.model.HouseDto
import java.util.*


class MainViewModel : ViewModel() {

    private var housesList: MutableLiveData<List<HouseDto>> = MutableLiveData()

    fun getHouses(): LiveData<List<HouseDto>> = housesList

    fun searchTextChanged(text: CharSequence) {
        val foo: List<HouseDto> = Collections.emptyList()

        housesList.value = foo
    }
}
