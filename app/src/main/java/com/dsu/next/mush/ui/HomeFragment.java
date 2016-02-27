package com.dsu.next.mush.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dsu.next.mush.R;
import com.dsu.next.mush.ui.controllers.HomeFragmentController;

public class HomeFragment extends Fragment {
    private HomeFragmentController controller;
    private Button goButton;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = new HomeFragmentController(this.getActivity());

        goButton = (Button) view.findViewById(R.id.go_button);
        addListeners();
    }

    private void addListeners() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onGoButtonPressed();
            }
        });
    }
}
