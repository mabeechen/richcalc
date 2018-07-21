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
import com.brazenhiker.richcalc.Calcs.Calc;
import com.brazenhiker.richcalc.Calcs.Operation;

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
    Calc calc = new Calc();

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
        zeroButton.setOnClickListener(view1 -> addNumberToValue("0"));

        oneButton = getView().findViewById(R.id.one_button);
        oneButton.setOnClickListener(v -> addNumberToValue("1"));

        twoButton = getView().findViewById(R.id.two_button);
        twoButton.setOnClickListener(v -> addNumberToValue("2"));

        threeButton = getView().findViewById(R.id.three_button);
        threeButton.setOnClickListener(view12 -> addNumberToValue("3"));

        fourButton = getView().findViewById(R.id.four_button);
        fourButton.setOnClickListener(view13 -> addNumberToValue("4"));

        fiveButton = getView().findViewById(R.id.five_button);
        fiveButton.setOnClickListener(view14 -> addNumberToValue("5"));

        sixButton = getView().findViewById(R.id.six_button);
        sixButton.setOnClickListener(view15 -> addNumberToValue("6"));

        sevenButton = getView().findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(view16 -> addNumberToValue("7"));

        eightButton = getView().findViewById(R.id.eight_button);
        eightButton.setOnClickListener(view17 -> addNumberToValue("8"));

        nineButton = getView().findViewById(R.id.nine_button);
        nineButton.setOnClickListener(view18 -> addNumberToValue("9"));

        equalsButton = getView().findViewById(R.id.equals_button);
        equalsButton.setOnClickListener(view19 -> {
                calc.addConstant(stringBuilderToDouble(displayBuilder));
                double result = calc.calculate();
                clearDisplay();
                displayBuilder.append(result);
                readOutText.setText(displayBuilder);
        });

        plusButton = getView().findViewById(R.id.plus_button);
        plusButton.setOnClickListener(view110 -> operationButtonClicked(Operation.ADDITION));

        minusButton = getView().findViewById(R.id.minus_button);
        minusButton.setOnClickListener(view111 -> operationButtonClicked(Operation.SUBTRACTION));

        multiplyButton = getView().findViewById(R.id.multiply_button);
        multiplyButton.setOnClickListener(view112 -> operationButtonClicked(Operation.MULTIPLICATION));

        divideButton = getView().findViewById(R.id.divide_button);
        divideButton.setOnClickListener(view113 -> operationButtonClicked(Operation.DIVISION));

        decimalButton = getView().findViewById(R.id.decimal_button);
        decimalButton.setOnClickListener(view114 -> {
            if (!displayBuilder.toString().contains(".")){
                addNumberToValue(".");
            }
        });

        signButton = getView().findViewById(R.id.sign_button);
        signButton.setOnClickListener(view115 -> {
                double signChange = stringBuilderToDouble(displayBuilder) * -1;
                clearDisplay();
                displayBuilder.append(signChange);
                readOutText.setText(displayBuilder);
        });

        percentButton = getView().findViewById(R.id.percent_button);
        percentButton.setOnClickListener(view116 -> {
            if (displayBuilder.length() != 0) {
                double percentage = stringBuilderToDouble(displayBuilder) / 100;
                clearDisplay();
                displayBuilder.append(percentage);
                readOutText.setText(displayBuilder);
            }
        });

        backButton = getView().findViewById(R.id.back_button);
        backButton.setOnClickListener(view117 -> {
            if (displayBuilder.length() != 0) {
                displayBuilder.deleteCharAt(displayBuilder.length() - 1);
                readOutText.setText(displayBuilder);
            }
        });

        clearButton = getView().findViewById(R.id.clear_button);
        clearButton.setOnClickListener(view118 -> clearDisplay());
    }

    private void clearDisplay() {
        displayBuilder.delete(0,displayBuilder.length());
        readOutText.setText("");
    }

    private double stringBuilderToDouble(StringBuilder displayBuilder) {
        if (displayBuilder.length() != 0) {
            return Double.parseDouble(displayBuilder.toString());
        }else {
            return 0;
        }
    }

    private void addNumberToValue(String value) {
        displayBuilder.append(value);
        readOutText.setText(displayBuilder);
    }

    private void operationButtonClicked(Operation operator) {
        calc.addConstant(stringBuilderToDouble(displayBuilder));
        calc.addOperator(operator);
        clearDisplay();
    }
}
