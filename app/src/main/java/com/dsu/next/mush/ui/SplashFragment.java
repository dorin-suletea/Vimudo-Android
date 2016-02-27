package com.dsu.next.mush.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsu.next.mush.R;

public class SplashFragment extends Fragment {

    public SplashFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loadHomeFragment();
        return inflater.inflate(R.layout.splash_fragment, container, false);
    }

    private void loadHomeFragment() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UiHelper.replaceCurrentFragment(SplashFragment.this.getActivity(), new Bundle(), new HomeFragment(), true, true);
            }
        }, UiHelper.SPLASH_DURATION);
    }
}
