package com.example.android.tourbenin;

public class Tour {

    /**
     * The name of the Tour location
     */
    private String mTourName;

    /**
     * Address of the Tour location
     */
    private String mTourAddress;

    /**
     * Description of the tour location
     */
    private String mTourContact;

    /**
     * Images of the Tour location
     */
    private int mTourImage = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a new Tour object.
     *
     * @param tourName is the name of the Tour location
     * @param tourContact is the Description of the tour location
     * @param tourAddress is the Address of the Tour location
     */
    public Tour(String tourName, String tourAddress, String tourContact) {
        mTourName = tourName;
        mTourAddress = tourAddress;
        mTourContact = tourContact;
    }

    /**
     * Create a new Tour object.
     *
     * @param tourName    is the name of the Tour location
     * @param tourContact is the Description of the tour location
     * @param tourAddress is the Address of the Tour location
     * @param tourImage   is the Image for the location
     */
    public Tour(String tourName, String tourAddress, String tourContact, int tourImage) {
        mTourName = tourName;
        mTourAddress = tourAddress;
        mTourContact = tourContact;
        mTourImage = tourImage;
    }

    /**
     * Get the name of the Tour location
     */
    public String getTourName() {
        return mTourName;
    }

    /**
     * Get the Address of the Tour location
     */
    public String getTourAddress() {
        return mTourAddress;
    }

    /**
     * Get the Description of the tour location
     */
    public String getTourContact() {
        return mTourContact;
    }


    /**
     * Return the Image for the location
     */
    public int getTourImage() {
        return mTourImage;
    }

    /**
     * Returns whether or not there is an image for this tour category.
     */
    public boolean hasImage() {

        return mTourImage != NO_IMAGE_PROVIDED;
    }
}
