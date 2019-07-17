package com.example.jpmccodingexercise;

import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.jpmccodingexercise.matchers.ItemCountMatcher;
import com.example.jpmccodingexercise.matchers.ItemPositionMatcher;
import com.example.jpmccodingexercise.ui.home.HomeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.appflate.restmock.RESTMockServer;
import io.appflate.restmock.utils.RequestMatchers;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {

    @Rule
    public final ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<>(HomeActivity.class,
            true, false);

    @Before
    public void setup() {
        RESTMockServer.whenGET(RequestMatchers.pathContains(BuildConfig.ALBUMS_ENDPOINT))
                .thenReturnFile("200_album_response.json");
        activityTestRule.launchActivity(new Intent());
    }

    @Test
    public void test_ActivityStarts_IsOnline_ShowsResultsFromApi() {
        IdlingRegistry.getInstance()
                .register(activityTestRule.getActivity().getCountingIdlingResource());
        onView(withId(R.id.rv_albums)).check(matches(ItemCountMatcher.withItemCount(7)));
    }

    @Test
    public void test_ActivityStarts_IsOnline_ResultsAreSortedAlphabetically() {
        IdlingRegistry.getInstance()
                .register(activityTestRule.getActivity().getCountingIdlingResource());
        onView(withId(R.id.rv_albums)).check(matches(ItemPositionMatcher.atPosition(0,
                hasDescendant(withText("eaque aut omnis a")))));
    }


}
