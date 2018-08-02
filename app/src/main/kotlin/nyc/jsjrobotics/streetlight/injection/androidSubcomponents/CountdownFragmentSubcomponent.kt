package nyc.jsjrobotics.streetlight.injection.androidSubcomponents

import dagger.Subcomponent
import dagger.android.AndroidInjector
import nyc.jsjrobotics.streetlight.countdown.CountdownFragment

@Subcomponent
interface CountdownFragmentSubcomponent : AndroidInjector<CountdownFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CountdownFragment>()

}