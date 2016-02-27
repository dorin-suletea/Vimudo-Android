package com.dsu.next.mush.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dsu.next.mush.R;
import com.dsu.next.mush.ui.adapters.LinkListAdapter;
import com.dsu.next.mush.ui.controllers.LinkListController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by next on 2/14/16.
 */
public class InfoFragment extends Fragment {
    private LinkListAdapter convertedLinkAdapter;

    public InfoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> mockConvertedLinks = new ArrayList<>();
        mockConvertedLinks.add("FFFFFFFFFF");
        mockConvertedLinks.add("FFSFFSFDASASD");
        mockConvertedLinks.add("FFFFFFFFFF");
        mockConvertedLinks.add("FFSFFSFDASASD");
        mockConvertedLinks.add("FFFFFFFFFF");
        mockConvertedLinks.add("FFSFFSFDASASD");
        mockConvertedLinks.add("FFFFFFFFFF");
        mockConvertedLinks.add("FFSFFSFDASASD");
        mockConvertedLinks.add("FFFFFFFFFF");
        mockConvertedLinks.add("FFSFFSFDASASD");

        convertedLinkAdapter = new LinkListAdapter(this.getActivity(), mockConvertedLinks, new LinkListController());
        ListView convertedLinkListView = (ListView) view.findViewById(R.id.converted_link_list);
        convertedLinkListView.setAdapter(convertedLinkAdapter);
    }
}
