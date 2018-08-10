package nyc.jsjrobotics.streetlight

import android.content.Context
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v4.app.FragmentActivity
import android.widget.FrameLayout
import com.nhaarman.mockitokotlin2.mock
import nyc.jsjrobotics.streetlight.lightDisplay.LightDisplayPresenter
import nyc.jsjrobotics.streetlight.lightDisplay.LightsDisplayFragment
import nyc.jsjrobotics.streetlight.lightDisplay.LightsDisplayView
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LightDisplayFragmentTest {
    class TestActivity : FragmentActivity()

    @JvmField
    @Rule
    var mActivityRule: ActivityTestRule<EspressoTestActivity> = ActivityTestRule(EspressoTestActivity::class.java)

    lateinit var testSubject : LightsDisplayFragment
    @Mock
    private lateinit var view: LightsDisplayView

    @Mock
    private lateinit var presenter: LightDisplayPresenter

    @Mock
    private lateinit var mMockContext: Context

    @Before
    fun setup() {
        testSubject = LightsDisplayFragment()
        testSubject.setTestingDependencies(view, presenter)
    }

    private fun addFragmentToActivity() {
        mActivityRule.activity
                .supportFragmentManager
                .beginTransaction()
                .add(android.R.id.content, testSubject, LightsDisplayFragment.TAG)
                .commit()
    }

    @Test
    @Ignore
    fun testLightsFound() {
        addFragmentToActivity()
        val expectedIds = listOf(
                R.id.red_light,
                R.id.yellow_light,
                R.id.green_light
        )
        expectedIds.forEach { testId ->
            Espresso.onView(ViewMatchers.withId(testId)).check(ViewAssertions.matches(ViewMatchers.isAssignableFrom(
                    FrameLayout::class.java)))
        }
    }
}