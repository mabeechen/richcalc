package com.brazenhiker.richcalc;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainHostActivityFragment extends Fragment {

    public static MainHostActivityFragment newInstance() {
        return new MainHostActivityFragment();
    }
    public MainHostActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_host, container, false);
    }
}
