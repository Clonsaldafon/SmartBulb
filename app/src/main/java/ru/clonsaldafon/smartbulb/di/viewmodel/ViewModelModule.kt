package ru.clonsaldafon.smartbulb.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.clonsaldafon.smartbulb.presentation.viewmodel.BrightnessViewModel
import ru.clonsaldafon.smartbulb.presentation.viewmodel.ColorViewModel
import ru.clonsaldafon.smartbulb.presentation.viewmodel.StateViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StateViewModel::class)
    abstract fun bindStateViewModel(viewModel: StateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ColorViewModel::class)
    abstract fun bindColorViewModel(viewModel: ColorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrightnessViewModel::class)
    abstract fun bindBrightnessViewModel(viewModel: BrightnessViewModel): ViewModel

}