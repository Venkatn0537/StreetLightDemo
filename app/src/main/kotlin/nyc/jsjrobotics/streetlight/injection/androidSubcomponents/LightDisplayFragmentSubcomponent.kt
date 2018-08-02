package nyc.jsjrobotics.streetlight.injection.androidSubcomponents

import dagger.Subcomponent
import dagger.android.AndroidInjector
import nyc.jsjrobotics.streetlight.lightDisplay.LightsDisplayFragment

@Subcomponent
interface LightDisplayFragmentSubcomponent : AndroidInjector<LightsDisplayFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<LightsDisplayFragment>()

}
