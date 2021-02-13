package shevtsov.daniil.asciiart.core

import android.app.Application
import shevtsov.daniil.asciiart.core.di.AppComponent
import shevtsov.daniil.asciiart.core.di.DaggerAppComponent

class AsciiArtApplication : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }

    fun getAppComponent() = appComponent

}
