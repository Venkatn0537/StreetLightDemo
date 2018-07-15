package nyc.jsjrobotics.praneethstreetlight

import android.os.Handler
import android.os.HandlerThread
import android.support.annotation.VisibleForTesting
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class LightStateMachine
@VisibleForTesting constructor(){
    companion object {
        var staticInstance : LightStateMachine = LightStateMachine()
    }
    var currentLight : LightOption = LightOption.RED

    var currentFrame: Int = 0 ; set(value) {
        field = value
        onNextFrame.onNext(value)
    }

    val onNextLight : PublishSubject<LightOption> = PublishSubject.create()
    val onNextFrame : PublishSubject<Int> = PublishSubject.create()

    val timerHandler : HandlerThread = HandlerThread("LightStateMachineTimer")
    var handler : Handler? = null

    fun nextLight() {
        currentLight = currentLight.getNextLight()
        onNextLight.onNext(currentLight)
    }

    fun incrementTimer() {
        currentFrame += 1
        if (currentFrame == currentLight.timeUntilNextLight) {
            nextLight()
            currentFrame = 0
        }
    }

    fun onNextLight(): Observable<LightOption> = onNextLight
    fun startTimer() {
        if (!timerHandler.isAlive) {
            timerHandler.start()
        }
        val newHandler = Handler(timerHandler.looper)
        newHandler.post{ sleepAndIncrement()}
        handler = newHandler
    }

    private fun sleepAndIncrement() {
        Thread.sleep(1000)
        incrementTimer()
        handler?.let {
            it.post{ sleepAndIncrement()}
        }
    }

    fun onNextFrame(): Observable<Int> = onNextFrame
}