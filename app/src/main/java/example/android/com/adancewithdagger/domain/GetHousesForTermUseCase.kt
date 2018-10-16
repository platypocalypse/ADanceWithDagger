package example.android.com.adancewithdagger.domain

import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.data.network.ApiService
import retrofit2.Retrofit
import javax.inject.Inject

class GetHousesForTermUseCase
    @Inject constructor(private val apiService: ApiService) {

//    fun call(term: String): List<HouseDto>? =
}