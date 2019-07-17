package com.example.jpmccodingexercise.matchers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class ItemPositionMatcher {
    public static Matcher<View> atPosition(final int position,
                                           @NonNull final Matcher<View> itemMatcher) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("Has item at position: " + position);
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {
                RecyclerView.ViewHolder viewHolder = recyclerView
                        .findViewHolderForAdapterPosition(position);
                if (viewHolder == null) {
                    throw new IllegalStateException("The ViewHolder cannot be null");
                }
                return itemMatcher.matches(viewHolder.itemView);
            }
        };
    }
}
