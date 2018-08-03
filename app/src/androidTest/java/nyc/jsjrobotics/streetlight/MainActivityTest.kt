package nyc.jsjrobotics.streetlight


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v4.app.Fragment
import junit.framework.Assert.assertNotNull
import nyc.jsjrobotics.streetlight.countdown.CountdownFragment
import nyc.jsjrobotics.streetlight.lightDisplay.LightsDisplayFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @JvmField
    @Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun testLightDisplayFragmentExists() {
        val fragmentFound : Fragment? = getFragmentByTag(LightsDisplayFragment.TAG)
        assertNotNull("Light display fragment should be present at startup", fragmentFound)
    }

    @Test
    fun testCountdownFragmentExists() {
        val fragmentFound : Fragment? = getFragmentByTag(CountdownFragment.TAG)
        assertNotNull("Countdown fragment should be present at startup", fragmentFound)
    }

    private fun getFragmentByTag(tag: String): Fragment? {
        return mActivityRule.activity
                .supportFragmentManager
                .findFragmentByTag(tag)
    }
}