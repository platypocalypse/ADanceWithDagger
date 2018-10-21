package example.android.com.adancewithdagger.domain

import example.android.com.adancewithdagger.data.network.ApiService
import example.android.com.adancewithdagger.data.repository.StoreHousesInRepo
import io.reactivex.functions.Action
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import timber.log.Timber
import javax.inject.Inject

class DownloadHousesUseCase
    @Inject constructor(private val apiService: ApiService,
                        private val storeHousesInRepo: StoreHousesInRepo) : Action {

    override fun run() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val request = apiService.getAllHouses()
                val response = request.await()
                if (response.isSuccessful) {
                    response.body()?.let { storeHousesInRepo.accept(it) }
                } else {
                    Timber.e(response.errorBody()!!.string())
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}