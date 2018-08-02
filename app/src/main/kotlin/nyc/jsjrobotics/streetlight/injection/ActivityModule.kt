package nyc.jsjrobotics.streetlight.injection

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import nyc.jsjrobotics.streetlight.MainActivity
import nyc.jsjrobotics.streetlight.injection.androidSubcomponents.CountdownFragmentSubcomponent
import nyc.jsjrobotics.streetlight.injection.androidSubcomponents.LightDisplayFragmentSubcomponent
import nyc.jsjrobotics.streetlight.injection.androidSubcomponents.MainActivitySubcomponent

@Module(subcomponents = arrayOf(
        MainActivitySubcomponent::class,
        CountdownFragmentSubcomponent::class,
        LightDisplayFragmentSubcomponent::class

))
abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivityInjectorFactory(builder: MainActivitySubcomponent.Builder): AndroidInjector.Factory<out Activity>
}
