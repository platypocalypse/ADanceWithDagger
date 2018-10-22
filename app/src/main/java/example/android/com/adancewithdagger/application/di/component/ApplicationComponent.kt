package example.android.com.adancewithdagger.application.di.component

import dagger.Component
import example.android.com.adancewithdagger.application.di.module.ApplicationModule
import example.android.com.adancewithdagger.application.di.module.ViewModelModule
import example.android.com.adancewithdagger.view.activity.MainActivity
import example.android.com.adancewithdagger.view.fragment.MainFragment
import javax.inject.Singleton


@Component(modules = [ApplicationModule::class, ViewModelModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
}