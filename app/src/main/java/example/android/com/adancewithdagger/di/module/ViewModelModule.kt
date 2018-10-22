package example.android.com.adancewithdagger.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module
import example.android.com.adancewithdagger.di.ViewModelFactory
import example.android.com.adancewithdagger.di.ViewModelKey
import example.android.com.adancewithdagger.viewmodel.MainViewModel


@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}