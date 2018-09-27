package com.example.android.tourbenin;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //An array of Restaurants
        final ArrayList<Tour> places = new ArrayList<>();
        places.add(new Tour(getString(R.string.hallmark), getString(R.string.hallmark_address), getString(R.string.hallmark_contact)));
        places.add(new Tour(getString(R.string.kada), getString(R.string.kada_address), getString(R.string.kada_contact)));
        places.add(new Tour(getString(R.string.gt), getString(R.string.gt_address), getString(R.string.gt_contact)));
        places.add(new Tour(getString(R.string.chicken), getString(R.string.chicken_address), getString(R.string.chicken_contact)));
        places.add(new Tour(getString(R.string.mama_ebo), getString(R.string.mama_ebo_address), getString(R.string.mama_ebo_contact)));
        places.add(new Tour(getString(R.string.omega), getString(R.string.omega_address), getString(R.string.omega_contact)));


        // An {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        TourAdapter adapter = new TourAdapter(getActivity(), places, R.color.category_colors);

        // This finds the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = rootView.findViewById(R.id.list);

        // This makes the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        listView.setAdapter(adapter);

        //Opens a new activity DetailsActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
