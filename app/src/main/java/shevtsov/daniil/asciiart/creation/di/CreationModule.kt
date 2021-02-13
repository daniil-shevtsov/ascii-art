package shevtsov.daniil.asciiart.creation.di

import dagger.Binds
import dagger.Module
import shevtsov.daniil.asciiart.core.di.AppScope
import shevtsov.daniil.asciiart.storage.data.TextStorageRepositoryImpl
import shevtsov.daniil.asciiart.storage.domain.TextStorageRepository

@Module
interface CreationModule {

    @AppScope
    @Binds
    fun bindStorageRepository(impl: TextStorageRepositoryImpl): TextStorageRepository

}