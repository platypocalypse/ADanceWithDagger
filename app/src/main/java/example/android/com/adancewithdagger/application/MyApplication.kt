package example.android.com.adancewithdagger.application

import android.app.Application
import example.android.com.adancewithdagger.application.di.component.ApplicationComponent
import example.android.com.adancewithdagger.application.di.component.DaggerApplicationComponent
import example.android.com.adancewithdagger.application.di.module.ApplicationModule
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