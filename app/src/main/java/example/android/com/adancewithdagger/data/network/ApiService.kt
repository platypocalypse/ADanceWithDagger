package example.android.com.adancewithdagger.data.network

import example.android.com.adancewithdagger.data.model.HouseDto
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("houses/")
    fun getAllHouses() : Deferred<Response<List<HouseDto>>>

}