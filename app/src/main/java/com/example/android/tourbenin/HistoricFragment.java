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
public class HistoricFragment extends Fragment {


    public HistoricFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //An array of Historic sites
        final ArrayList<Tour> places = new ArrayList<>();
        places.add(new Tour(getString(R.string.palace), getString(R.string.palace_address), getString(R.string.palace_contact), R.drawable.oba_palace));
        places.add(new Tour(getString(R.string.moat), getString(R.string.moat_address), getString(R.string.moat_contact), R.drawable.benin_moat));
        places.add(new Tour(getString(R.string.igun), getString(R.string.igun_address), getString(R.string.igun_contact), R.drawable.igun_street));
        places.add(new Tour(getString(R.string.museum), getString(R.string.museum_address), getString(R.string.museum_contact), R.drawable.national_museum));

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