package com.example.android.tourbenin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourAdapter extends ArrayAdapter<Tour> {
    private int mColorResourceId;

    public TourAdapter(Context context, ArrayList<Tour> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Tour currentTour = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        assert currentTour != null;
        nameTextView.setText(currentTour.getTourName());
        // Find the TextView in the list_item.xml layout with the ID contact_text_view
        TextView contactTextView = listItemView.findViewById(R.id.contact_text_view);

        contactTextView.setText(currentTour.getTourContact());
        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView addressTextView = listItemView.findViewById(R.id.address_text_view);

        addressTextView.setText(currentTour.getTourAddress());
        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = listItemView.findViewById(R.id.image);

        if (currentTour.hasImage()) {
            // set this ImageView to the image resource specified in the current word
            imageView.setImageResource(currentTour.getTourImage());
            //make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }else{
            //otherwise hide the imageView
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 3 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
