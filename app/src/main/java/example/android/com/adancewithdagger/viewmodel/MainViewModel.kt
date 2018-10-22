package example.android.com.adancewithdagger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.domain.DownloadHousesUseCase
import example.android.com.adancewithdagger.domain.GetHousesForTermUseCase
import javax.inject.Inject


class MainViewModel
    @Inject constructor(private val downloadHousesUseCase: DownloadHousesUseCase,
                        private val getHousesForTermUseCase: GetHousesForTermUseCase) : ViewModel() {

    private var housesList: MutableLiveData<List<HouseDto>> = MutableLiveData()

    fun getHouses(): LiveData<List<HouseDto>> = housesList

    fun downloadHouses() = downloadHousesUseCase.run()

    fun searchTextChanged(text: CharSequence) {
        housesList.postValue(getHousesForTermUseCase.apply(text.toString()))
    }
}
