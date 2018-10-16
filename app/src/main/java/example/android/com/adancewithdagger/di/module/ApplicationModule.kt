package example.android.com.adancewithdagger.di.module

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import example.android.com.adancewithdagger.data.network.ApiService
import example.android.com.adancewithdagger.di.ViewModelFactory
import example.android.com.adancewithdagger.di.ViewModelKey
import example.android.com.adancewithdagger.view.viewmodel.MainViewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    fun context(): Context = context

    @Provides
    @Singleton
    fun retrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.anapioficeandfire.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun apiService(): ApiService = retrofit().create(ApiService::class.java)
}