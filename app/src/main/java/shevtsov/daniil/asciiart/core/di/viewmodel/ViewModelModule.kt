package shevtsov.daniil.asciiart.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shevtsov.daniil.asciiart.core.di.AppScope
import shevtsov.daniil.asciiart.creation.presentation.CreationViewModel
import shevtsov.daniil.asciiart.learning.presentation.LearningViewModel
import shevtsov.daniil.asciiart.main.presentation.MainViewModel
import shevtsov.daniil.asciiart.structure.presentation.StructureViewModel

@Module
interface ViewModelModule {

    @Binds
    @AppScope
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModelMain: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreationViewModel::class)
    fun bindCreationViewModel(viewModel: CreationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StructureViewModel::class)
    fun bindStructureViewModel(viewModel: StructureViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LearningViewModel::class)
    fun bindLearningViewModel(viewModel: LearningViewModel): ViewModel

}
