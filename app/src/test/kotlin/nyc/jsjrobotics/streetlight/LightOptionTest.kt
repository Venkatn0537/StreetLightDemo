package nyc.jsjrobotics.streetlight

import junit.framework.Assert.assertEquals
import org.junit.Test

class LightOptionTest {

    @Test
    fun testNextLightState() {
        val expectedNextLight = listOf(
                Pair(LightOption.RED, LightOption.GREEN),
                Pair(LightOption.GREEN, LightOption.YELLOW),
                Pair(LightOption.YELLOW, LightOption.RED)
        )
        expectedNextLight.forEach { (testSubject, expectedResult) ->
            assertEquals("Returned wrong value for next light", expectedResult, testSubject.getNextLight() )
        }
    }
}