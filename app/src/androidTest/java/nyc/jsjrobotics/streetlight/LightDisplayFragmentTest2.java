package nyc.jsjrobotics.streetlight;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.FrameLayout;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import nyc.jsjrobotics.streetlight.lightDisplay.LightDisplayPresenter;
import nyc.jsjrobotics.streetlight.lightDisplay.LightsDisplayFragment;
import nyc.jsjrobotics.streetlight.lightDisplay.LightsDisplayView;

import static org.mockito.Mockito.mock;

@RunWith(AndroidJUnit4.class)
public class LightDisplayFragmentTest2 {
    @Rule
    public ActivityTestRule<EspressoTestActivity> activityRule = new ActivityTestRule<>(EspressoTestActivity.class);
    private LightsDisplayFragment testSubject;
    private LightsDisplayView view = mock(LightsDisplayView.class);
    private LightDisplayPresenter presenter = mock(LightDisplayPresenter.class);

    @Before
    public void setup() {
        testSubject = new LightsDisplayFragment();
        testSubject.setTestingDependencies(view, presenter);
    }

    private void addFragmentToActivity() {
        activityRule.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, testSubject, LightsDisplayFragment.TAG)
                .commit();
    }

    @Test
    public void testLightsFound() {
        addFragmentToActivity();
        List<Integer> expectedIds = Arrays.asList(
                R.id.red_light,
                R.id.yellow_light,
                R.id.green_light
        );
        expectedIds.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(final Integer testId) {
                Espresso.onView(ViewMatchers.withId(testId)).check(ViewAssertions.matches(ViewMatchers.isAssignableFrom(
                        FrameLayout.class)));
            }
        });
    }
}
