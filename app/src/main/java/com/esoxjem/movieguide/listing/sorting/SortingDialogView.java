package com.esoxjem.movieguide.listing.sorting;


interface SortingDialogView {
    void setPopularChecked();

    void setNewestChecked();

    void setHighestRatedChecked();

    void setFavoritesChecked();

    void dismissDialog();

}
