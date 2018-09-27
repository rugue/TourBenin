package com.example.android.tourbenin;


import android.content.Intent;
import android.os.Bundle;
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
public class RecreationalFragment extends Fragment {


    public RecreationalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //An array of Recreational Centres
        final ArrayList<Tour> places = new ArrayList<>();
        places.add(new Tour(getString(R.string.ogba), getString(R.string.ogba_address), getString(R.string.ogba_contact), R.drawable.ogba_zoo));
        places.add(new Tour(getString(R.string.bethel), getString(R.string.bethel_address), getString(R.string.bethel_contact), R.drawable.bethel_home));
        places.add(new Tour(getString(R.string.king), getString(R.string.king_address), getString(R.string.king_contact), R.drawable.ring_road));
        places.add(new Tour(getString(R.string.okomu), getString(R.string.okomu_address), getString(R.string.okomu_contact), R.drawable.okomu));

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
