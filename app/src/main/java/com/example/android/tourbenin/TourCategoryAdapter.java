package com.example.android.tourbenin;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link TourCategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Tour} objects.
 */
public class TourCategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link TourCategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public TourCategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricFragment();
        } else if (position == 1) {
            return new HotelsFragment();
        }else if (position == 2){
            return new RestaurantsFragment();
        }else {
            return new RecreationalFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.historic_sites);
        } else if (position == 1) {
            return mContext.getString(R.string.hotels);
        } else if(position == 2){
            return mContext.getString(R.string.restaurants);
        }else{
            return mContext.getString(R.string.recreational);
        }
    }
}
