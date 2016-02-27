package com.dsu.next.mush.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dsu.next.mush.R;
import com.dsu.next.mush.ui.controllers.LinkListController;

import java.util.List;

/**
 * Created by next on 2/14/16.
 */
public class LinkListAdapter extends ArrayAdapter<String> {
    private List<String> shownItems;
    private LayoutInflater inflater;

    public LinkListAdapter(Context context, List<String> objects, LinkListController fragmentController) {
        super(context, 0, objects);
        shownItems = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String currentLink = shownItems.get(position);


        View rowView;
        if (convertView == null) {
            rowView = inflater.inflate(R.layout.row_converted_link, parent, false);
        } else {
            rowView = convertView;
        }

        TextView linkDefinition = (TextView) rowView.findViewById(R.id.link_definition);
        linkDefinition.setText(currentLink);
        return rowView;
    }
}