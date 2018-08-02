package nyc.jsjrobotics.streetlight.countdown

import nyc.jsjrobotics.streetlight.LightStateMachine
import javax.inject.Inject

class CountdownFragmentPresenter @Inject constructor() {
    lateinit var view : CountdownFragmentView

    fun subscribeToDisplayUpdates(v : CountdownFragmentView) {
        view = v
        lightStateMachine.onNextFrame()
                .subscribe{ currentFrameNumber ->
                    view.displayCurrentFrame(currentFrameNumber)
                }
    }

    val lightStateMachine = LightStateMachine.staticInstance

}
