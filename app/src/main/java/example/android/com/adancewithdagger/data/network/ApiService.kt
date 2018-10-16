package example.android.com.adancewithdagger.data.network

import example.android.com.adancewithdagger.data.model.HouseDto
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("houses/{term}")
    fun getHouses(@Path("term") term: String) : Deferred<Response<List<HouseDto>>>

}