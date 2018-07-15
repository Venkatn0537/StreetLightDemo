package nyc.jsjrobotics.praneethstreetlight.lightDisplay

import android.os.Handler
import nyc.jsjrobotics.praneethstreetlight.LightOption
import nyc.jsjrobotics.praneethstreetlight.LightStateMachine

class LightDisplayPresenter {
    lateinit var lightDisplay: LightsDisplayView
    val lightStateMachine = LightStateMachine.staticInstance

    fun setView(v: LightsDisplayView) {
        lightDisplay = v
        v.setLight(lightStateMachine.currentLight)
        subscribeToStateMachine()
    }

    private fun subscribeToStateMachine() {
        lightStateMachine.onNextLight().subscribe { nextLight ->
            lightDisplay.setLight(nextLight)
        }
    }

    fun startTimer() {
        lightStateMachine.startTimer()
    }


}
