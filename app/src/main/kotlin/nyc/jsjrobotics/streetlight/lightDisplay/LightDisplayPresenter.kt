package nyc.jsjrobotics.streetlight.lightDisplay

import nyc.jsjrobotics.streetlight.LightStateMachine
import javax.inject.Inject

class LightDisplayPresenter @Inject constructor(val lightStateMachine : LightStateMachine){
    lateinit var lightDisplay: LightsDisplayView

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
