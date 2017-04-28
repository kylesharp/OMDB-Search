package com.kpsharp.omdbsearch.ui.movielist;

import com.kpsharp.omdbsearch.R;
import com.kpsharp.omdbsearch.base.BaseEspressoTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MovieListActivityEspressoTest extends BaseEspressoTest {

    // region Variables

    @Rule
    public ActivityTestRule<MovieListActivity> mActivityTestRule = new ActivityTestRule<>(MovieListActivity.class);

    // endregion

    // region Tests

    @Test
    public void testSearchBarAcceptsInput() throws Exception {

        searchForText("movie");
    }

    @Test
    public void testSearchResults() throws Exception {

        searchForText("movie");

        for (int i=0; i<5; i++) {
            onView(withId(R.id.movie_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
        }
    }

    // endregion

    // region Helpers

    private void searchForText(String text) {

        onView(withId(R.id.movie_search_view)).check(matches(isDisplayed()));

        // SearchViews use search_button and search_src_text
        onView(withId(R.id.search_button)).perform(click());

        onView(withId(R.id.search_src_text)).perform(typeText(text));

        onView(withId(R.id.search_src_text)).check(matches(withText(text))).perform(pressImeActionButton());
    }

    // endregion
}
