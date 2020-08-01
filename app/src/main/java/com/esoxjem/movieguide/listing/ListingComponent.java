package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.listing.sorting.SortingDialogFragment;
import com.esoxjem.movieguide.listing.sorting.SortingModule;

import dagger.Subcomponent;


@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent {
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
