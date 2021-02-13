package shevtsov.daniil.asciiart.core.di

import dagger.Component
import shevtsov.daniil.asciiart.creation.di.CreationModule
import shevtsov.daniil.asciiart.creation.view.CreationFragment
import shevtsov.daniil.asciiart.learning.view.LearningFragment
import shevtsov.daniil.asciiart.main.view.MainFragment
import shevtsov.daniil.asciiart.structure.view.StructureFragment

@AppScope
@Component(
    modules = [AppModule::class, CreationModule::class]
)
interface AppComponent {

    fun inject(mainFragment: MainFragment)

    fun inject(creationFragment: CreationFragment)

    fun inject(structureFragment: StructureFragment)

    fun inject(learningFragment: LearningFragment)

}
