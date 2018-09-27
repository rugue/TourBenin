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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //Create an array of Hotels
        final ArrayList<Tour> places = new ArrayList<>();
        places.add(new Tour(getString(R.string.randekhi), getString(R.string.randekhi_address), getString(R.string.randekhi_contact), R.drawable.randekhi_gold));
        places.add(new Tour(getString(R.string.protea), getString(R.string.protea_address), getString(R.string.protea_contact), R.drawable.protea_hotel));
        places.add(new Tour(getString(R.string.uyi), getString(R.string.uyi_address), getString(R.string.uyi_contact), R.drawable.uyi_grand_hotel));
        places.add(new Tour(getString(R.string.prestige), getString(R.string.prestige_address), getString(R.string.prestige_contact), R.drawable.prestige_hotel));


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
