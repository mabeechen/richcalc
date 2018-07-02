package com.brazenhiker.richcalc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainHostActivityFragment extends Fragment {

    TextView readOutText;
    Button oneButton;
    Button twoButton;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readOutText = getView().findViewById(R.id.readOutText);

        oneButton = getView().findViewById(R.id.one_button);
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { readOutText.setText("1");
            }
        });

        twoButton = getView().findViewById(R.id.two_button);
        twoButton.setOnClickListener(v -> readOutText.setText("2"));
    }
}
