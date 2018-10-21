package example.android.com.adancewithdagger.domain

import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.data.network.ApiService
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import java.util.function.Function
import javax.inject.Inject

class GetHousesForTermUseCase
    @Inject constructor(private val apiService: ApiService) : Function<String, Deferred<Response<List<HouseDto>>>> {

    override fun apply(term: String): Deferred<Response<List<HouseDto>>>
            = apiService.getHouses(term)
}