package nyc.jsjrobotics.streetlight.injection

import dagger.Component
import dagger.android.AndroidInjectionModule
import nyc.jsjrobotics.streetlight.Application
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        FragmentModule::class,
        PresenterModule::class,
        ModelModule::class
))

interface ApplicationComponent {
    fun inject(app: Application)
    // Explicitly declare function returning a Provided object for dagger binding
    fun getApplication(): Application
}