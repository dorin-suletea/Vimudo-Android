package com.dsu.next.mush.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.dsu.next.mush.R;

/**
 * Created by next on 2/13/16.
 */
public class UiHelper {
    public static final long SPLASH_DURATION = 2000;

    public static void replaceCurrentFragment(Activity activity, Bundle params, Fragment newFragment,
                                              boolean addToStack, boolean animated) {
        newFragment.setArguments(params);
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();


        if (animated) {
            transaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left,0,0);
        }

        transaction.replace(R.id.fragment_place, newFragment);
        if (addToStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
