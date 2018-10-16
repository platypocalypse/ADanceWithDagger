package example.android.com.adancewithdagger.data.network

import example.android.com.adancewithdagger.data.model.HouseDto
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("houses/")
    fun getHouses(@Query("name") term: String) : Deferred<Response<List<HouseDto>>>

}