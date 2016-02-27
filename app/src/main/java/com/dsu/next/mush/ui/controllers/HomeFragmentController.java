package com.dsu.next.mush.ui.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.dsu.next.mush.ui.InfoFragment;
import com.dsu.next.mush.ui.UiHelper;

/**
 * Created by next on 2/14/16.
 */
public class HomeFragmentController {
    private Activity parentActivity;

    public HomeFragmentController(Activity parentActivity) {
        this.parentActivity = parentActivity;
    }

    public void onGoButtonPressed() {
        Log.d("=!=",(parentActivity==null)+"");
        UiHelper.replaceCurrentFragment(parentActivity, new Bundle(), new InfoFragment(), true, true);
    }
}
