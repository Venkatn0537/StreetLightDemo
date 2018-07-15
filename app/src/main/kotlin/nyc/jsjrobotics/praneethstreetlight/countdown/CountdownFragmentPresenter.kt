package nyc.jsjrobotics.praneethstreetlight.countdown

import nyc.jsjrobotics.praneethstreetlight.LightStateMachine

class CountdownFragmentPresenter {
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
