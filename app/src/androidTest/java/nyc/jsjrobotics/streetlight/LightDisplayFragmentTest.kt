package nyc.jsjrobotics.streetlight

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule


import android.support.test.rule.ActivityTestRule;
import android.view.View


@RunWith(AndroidJUnit4::class)
class LightDisplayFragmentTest {
    @JvmField
    @Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun testInitLights() {
        val expectedIds = listOf(
                Pair(R.id.red_light, ViewMatchers.Visibility.VISIBLE),
                Pair(R.id.yellow_light, ViewMatchers.Visibility.INVISIBLE),
                Pair(R.id.green_light, ViewMatchers.Visibility.INVISIBLE)
        )
        expectedIds.forEach { (testId, expectedVisibility) ->
            onView(withId(testId)).check(matches(withEffectiveVisibility(expectedVisibility)))
        }
    }
}