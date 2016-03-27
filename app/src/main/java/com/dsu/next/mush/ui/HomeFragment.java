package com.dsu.next.mush.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dsu.next.mush.R;
import com.dsu.next.mush.ui.controllers.HomeFragmentController;

import model.VimudoConstants;

public class HomeFragment extends Fragment {
    private HomeFragmentController controller;
    private Button searchButton;
    private ProgressBar progressBar;
    private EditText searchBox;
    private boolean alreadySearched;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.b_search_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = new HomeFragmentController(this.getActivity(), this);

        searchButton = (Button) view.findViewById(R.id.search_button);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        searchBox = (EditText) view.findViewById(R.id.edit_box);
        addListeners();

        //we opened this on intent from other activities
        Bundle fragmentArguments = getArguments();
        if (fragmentArguments != null && fragmentArguments.containsKey(VimudoConstants.INTENT_LINK_KEY)) {
            String receivedLink = fragmentArguments.getString(VimudoConstants.INTENT_LINK_KEY);
            searchBox.setText(receivedLink);
            //execute the url

            //if resotred from pressing back, populate the string but don't pres go search
            if (!alreadySearched) {
                controller.executeSearchAction(searchBox.getText().toString());
                alreadySearched = true;
            }
        }
    }

    private void addListeners() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.executeSearchAction(searchBox.getText().toString());
            }
        });
    }

    public void searchStarted() {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                searchButton.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    public void searchEnded() {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                searchButton.setEnabled(true);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void onSearchError(final String error) {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(HomeFragment.this.getActivity(), error, Toast.LENGTH_LONG);
            }
        });
    }
}
