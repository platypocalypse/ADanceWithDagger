package example.android.com.adancewithdagger.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.domain.GetHousesForTermUseCase
import java.util.*
import javax.inject.Inject


class MainViewModel
    @Inject constructor(private val getHousesForTermUseCase: GetHousesForTermUseCase)
    : ViewModel() {

    private var housesList: MutableLiveData<List<HouseDto>> = MutableLiveData()

    fun getHouses(): LiveData<List<HouseDto>> = housesList

    fun searchTextChanged(text: CharSequence) {
        val foo: List<HouseDto>? = getHousesForTermUseCase.call(text.toString())
        housesList.value = foo
    }
}
