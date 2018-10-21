package example.android.com.adancewithdagger

import android.app.Application
import example.android.com.adancewithdagger.di.component.ApplicationComponent
import example.android.com.adancewithdagger.di.component.DaggerApplicationComponent
import example.android.com.adancewithdagger.di.module.ApplicationModule
import io.realm.Realm

class MyApplication: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        Realm.init(this)
    }


    companion object {
        private var INSTANCE: MyApplication? = null
        @JvmStatic
        fun get(): MyApplication = INSTANCE!!
    }
}