package shevtsov.daniil.asciiart.core.di

import dagger.Module
import dagger.Provides
import shevtsov.daniil.asciiart.core.di.api.network.NetworkModule
import shevtsov.daniil.asciiart.core.di.viewmodel.ViewModelModule
import shevtsov.daniil.asciiart.core.util.logging.AndroidLogger
import shevtsov.daniil.asciiart.core.util.logging.Logger

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class
    ]
)
class AppModule {

    @Provides
    fun provideLogger(): Logger = AndroidLogger()

}
