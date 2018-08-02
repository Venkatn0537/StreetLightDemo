package nyc.jsjrobotics.streetlight.injection

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import nyc.jsjrobotics.streetlight.countdown.CountdownFragment
import nyc.jsjrobotics.streetlight.injection.androidSubcomponents.CountdownFragmentSubcomponent
import nyc.jsjrobotics.streetlight.injection.androidSubcomponents.LightDisplayFragmentSubcomponent
import nyc.jsjrobotics.streetlight.lightDisplay.LightsDisplayFragment

@Module
abstract class FragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(CountdownFragment::class)
    internal abstract fun bindCountdownFragmentInjectorFactory(builder: CountdownFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(LightsDisplayFragment::class)
    internal abstract fun bindLightsDisplayFragmentInjectorFactory(builder: LightDisplayFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>

}