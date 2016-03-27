package com.dsu.next.mush.ui.controllers;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.dsu.next.mush.ui.HomeFragment;
import com.dsu.next.mush.ui.InfoFragment;
import com.dsu.next.mush.ui.UiHelper;

/**
 * Created by next on 2/14/16.
 */
public class HomeFragmentController {
    private Activity parentActivity;
    private HomeFragment parentFragment;

    public HomeFragmentController(Activity parentActivity, HomeFragment parentFragment) {
        this.parentActivity = parentActivity;
        this.parentFragment = parentFragment;
    }

    public void executeSearchAction(String link) {
        parentFragment.searchStarted();
        ConvertLinkTask convertTask = new ConvertLinkTask();
        convertTask.execute(link);
    }

    public void onSearchFinished() {
        UiHelper.replaceCurrentFragment(parentActivity, new Bundle(), new InfoFragment(), true, true);
        parentFragment.searchEnded();
    }

    private class ConvertLinkTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            onSearchFinished();
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
