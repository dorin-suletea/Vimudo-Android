package com.dsu.next.mush.ui;

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
    private Button searchButton;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.b_search_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = new HomeFragmentController(this.getActivity());

        searchButton = (Button) view.findViewById(R.id.search_button);
        addListeners();
    }

    private void addListeners() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onGoButtonPressed();
            }
        });
    }
}
