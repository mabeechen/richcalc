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
    Button zeroButton,
            oneButton,
            twoButton,
            threeButton,
            fourButton,
            fiveButton,
            sixButton,
            sevenButton,
            eightButton,
            nineButton,
            equalsButton,
            plusButton,
            minusButton,
            multiplyButton,
            divideButton,
            decimalButton,
            signButton,
            percentButton,
            backButton,
            clearButton;
    StringBuilder displayBuilder = new StringBuilder();

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

        zeroButton = getView().findViewById(R.id.zero_button);
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToValue("0");
            }
        });

        oneButton = getView().findViewById(R.id.one_button);
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumberToValue("1");
            }
        });

        twoButton = getView().findViewById(R.id.two_button);
        twoButton.setOnClickListener(v -> addNumberToValue("2"));

        threeButton = getView().findViewById(R.id.three_button);
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToValue("3");
            }
        });

        fourButton = getView().findViewById(R.id.four_button);
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToValue("4");
            }
        });

        fiveButton = getView().findViewById(R.id.five_button);
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToValue("5");
            }
        });

        sixButton = getView().findViewById(R.id.six_button);
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToValue("6");
            }
        });

        sevenButton = getView().findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToValue("7");
            }
        });

        eightButton = getView().findViewById(R.id.eight_button);
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToValue("8");
            }
        });

        nineButton = getView().findViewById(R.id.nine_button);
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberToValue("9");
            }
        });

        equalsButton = getView().findViewById(R.id.equals_button);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readOutText.setText("=");
            }
        });

        plusButton = getView().findViewById(R.id.plus_button);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readOutText.setText("+");
            }
        });

        minusButton = getView().findViewById(R.id.minus_button);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readOutText.setText("-");
            }
        });

        multiplyButton = getView().findViewById(R.id.multiply_button);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readOutText.setText("*");
            }
        });

        divideButton = getView().findViewById(R.id.divide_button);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readOutText.setText("/");
            }
        });

        decimalButton = getView().findViewById(R.id.decimal_button);
        decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (displayBuilder.toString().contains(".") == false){
                    addNumberToValue(".");
                }
            }
        });

        signButton = getView().findViewById(R.id.sign_button);
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readOutText.setText("+/-");
            }
        });

        percentButton = getView().findViewById(R.id.percent_button);
        percentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readOutText.setText("%");
            }
        });

        backButton = getView().findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayBuilder.deleteCharAt(displayBuilder.length()-1);
                readOutText.setText(displayBuilder);
            }
        });

        clearButton = getView().findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayBuilder.delete(0,displayBuilder.length());
                readOutText.setText("");
            }
        });
    }

    private void addNumberToValue(String value) {
        displayBuilder.append(value);
        readOutText.setText(displayBuilder);
    }
}
