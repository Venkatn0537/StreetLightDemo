package nyc.jsjrobotics.streetlight

import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


class LightStateMachineTest {
    lateinit var testSubject: LightStateMachine

    @Before
    fun setup() {
        testSubject = LightStateMachine()
    }

    @Test
    fun `test Light Machine init state`() {
        assertTrue("Test machine should initialize on red light", testSubject.currentLight == LightOption.RED)
        assertTrue("Street light model must start on 0 frame", testSubject.currentFrame == 0)
    }

    @Test
    fun `test next light button`() {
        assertTrue("Test machine should initialize on red light", testSubject.currentLight == LightOption.RED)
        testSubject.nextLight()
        assertTrue("Test machine should go from red to green", testSubject.currentLight == LightOption.GREEN)
        testSubject.nextLight()
        assertTrue("Test machine should go from green to yellow", testSubject.currentLight == LightOption.YELLOW)
        testSubject.nextLight()
        assertTrue("Test machine should go from yellow to red", testSubject.currentLight == LightOption.RED)
    }

    @Test
    fun `test timer increment changes light`() {
        assertTrue("Test machine should initialize with current frame at 0", testSubject.currentFrame == 0)
        LightOption.values()
                .forEach { testLight ->
                    testSubject.currentLight = testLight
                    IntRange(1, testLight.timeUntilNextLight)
                            .forEach {
                                testSubject.incrementTimer()
                            }
                    assertTrue(
                            "Ater ${testLight.name} and ${testLight.timeUntilNextLight} frames, should see ${testLight.getNextLight()}",
                            testSubject.currentLight == testLight.getNextLight())
                }


    }
}