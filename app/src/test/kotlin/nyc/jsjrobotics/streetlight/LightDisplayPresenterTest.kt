package nyc.jsjrobotics.streetlight

import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.subjects.PublishSubject
import nyc.jsjrobotics.streetlight.lightDisplay.LightDisplayPresenter
import nyc.jsjrobotics.streetlight.lightDisplay.LightsDisplayView
import org.junit.Before
import org.junit.Test

class LightDisplayPresenterTest {
    lateinit var lightsDisplayView: LightsDisplayView
    lateinit var testSubject: LightDisplayPresenter
    lateinit var lightStateMachine: LightStateMachine

    private val nextLightPublisher: PublishSubject<LightOption> = PublishSubject.create()

    @Before
    fun setup() {
        lightsDisplayView = mock {}
        lightStateMachine = mock {
            on { currentLight } doAnswer { LightOption.RED }
            on { onNextLight() } doReturn ( nextLightPublisher )
        }
        lightStateMachine.onNextLight()
        testSubject = LightDisplayPresenter(lightStateMachine)
    }

    @Test
    fun testSetView() {
        testSubject.setView(lightsDisplayView)
        verify(lightsDisplayView).setLight(lightStateMachine.currentLight)
    }

    @Test
    fun testStartTimer() {
        testSubject.startTimer()
        verify(lightStateMachine).startTimer()
    }
}