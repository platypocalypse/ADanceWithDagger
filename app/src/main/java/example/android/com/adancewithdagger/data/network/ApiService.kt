package example.android.com.adancewithdagger.data.network

import example.android.com.adancewithdagger.data.model.HouseDto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

interface ApiService {

    @GET("houses/{term}")
    fun getHouses(@Path("term") term: String) : Call<List<HouseDto>>

}