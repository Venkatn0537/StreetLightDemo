package nyc.jsjrobotics.streetlight.lightDisplay

import android.os.Handler
import nyc.jsjrobotics.streetlight.LightOption
import javax.inject.Inject
import nyc.jsjrobotics.streetlight.LightStateMachine

class LightDisplayPresenter @Inject constructor(){
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
