package com.example.jpmccodingexercise.matchers;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.Objects;

public class ItemCountMatcher {
    public static Matcher<View> withItemCount(int itemCount) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("Item count is: " + itemCount);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {
                return Objects.requireNonNull(recyclerView.getAdapter()).getItemCount() == itemCount;
            }
        };
    }
}
