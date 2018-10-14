package example.android.com.adancewithdagger.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    fun context(): Context = context

    @Provides
    @Singleton
    fun retrofit() =
        Retrofit.Builder()
            .baseUrl("https://www.anapioficeandfire.com/api")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}