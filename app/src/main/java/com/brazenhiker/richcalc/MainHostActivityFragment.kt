package com.brazenhiker.richcalc

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.brazenhiker.richcalc.Calcs.Calc
import com.brazenhiker.richcalc.Calcs.Operation

/**
 * A placeholder fragment containing a simple view.
 */
class MainHostActivityFragment : Fragment() {

    private var resetSummary = false

    lateinit var readOutText: TextView
    lateinit var summaryTextView: TextView
    lateinit var zeroButton: Button
    lateinit var oneButton: Button
    lateinit var twoButton: Button
    lateinit var threeButton: Button
    lateinit var fourButton: Button
    lateinit var fiveButton: Button
    lateinit var sixButton: Button
    lateinit var sevenButton: Button
    lateinit var eightButton: Button
    lateinit var nineButton: Button
    lateinit var equalsButton: Button
    lateinit var plusButton: Button
    lateinit var minusButton: Button
    lateinit var multiplyButton: Button
    lateinit var divideButton: Button
    lateinit var decimalButton: Button
    lateinit var signButton: Button
    lateinit var percentButton: Button
    lateinit var backButton: Button
    lateinit var clearButton: Button
    var displayBuilder = StringBuilder()
    var summaryText = ""
    var calc = Calc()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readOutText = getView()!!.findViewById(R.id.readOutText)
        summaryTextView = getView()!!.findViewById(R.id.summaryText)

        zeroButton = getView()!!.findViewById(R.id.zero_button)
        zeroButton.setOnClickListener { view1 -> addNumberToValue("0") }

        oneButton = getView()!!.findViewById(R.id.one_button)
        oneButton.setOnClickListener { v -> addNumberToValue("1") }

        twoButton = getView()!!.findViewById(R.id.two_button)
        twoButton.setOnClickListener { v -> addNumberToValue("2") }

        threeButton = getView()!!.findViewById(R.id.three_button)
        threeButton.setOnClickListener { view12 -> addNumberToValue("3") }

        fourButton = getView()!!.findViewById(R.id.four_button)
        fourButton.setOnClickListener { view13 -> addNumberToValue("4") }

        fiveButton = getView()!!.findViewById(R.id.five_button)
        fiveButton.setOnClickListener { view14 -> addNumberToValue("5") }

        sixButton = getView()!!.findViewById(R.id.six_button)
        sixButton.setOnClickListener { view15 -> addNumberToValue("6") }

        sevenButton = getView()!!.findViewById(R.id.seven_button)
        sevenButton.setOnClickListener { view16 -> addNumberToValue("7") }

        eightButton = getView()!!.findViewById(R.id.eight_button)
        eightButton.setOnClickListener { view17 -> addNumberToValue("8") }

        nineButton = getView()!!.findViewById(R.id.nine_button)
        nineButton.setOnClickListener { view18 -> addNumberToValue("9") }

        equalsButton = getView()!!.findViewById(R.id.equals_button)
        equalsButton.setOnClickListener { view19 ->
            resetSummary = true
            summaryText += displayBuilder.toString()
            summaryTextView.text = summaryText
            calc.addConstant(stringBuilderToDouble(displayBuilder))
            val result = calc.calculate()
            clearDisplay()
            displayBuilder.append(result)
            readOutText.text = displayBuilder
        }

        plusButton = getView()!!.findViewById(R.id.plus_button)
        plusButton.setOnClickListener { view110 -> operationButtonClicked(Operation.ADDITION) }

        minusButton = getView()!!.findViewById(R.id.minus_button)
        minusButton.setOnClickListener { view111 -> operationButtonClicked(Operation.SUBTRACTION) }

        multiplyButton = getView()!!.findViewById(R.id.multiply_button)
        multiplyButton.setOnClickListener { view112 -> operationButtonClicked(Operation.MULTIPLICATION) }

        divideButton = getView()!!.findViewById(R.id.divide_button)
        divideButton.setOnClickListener { view113 -> operationButtonClicked(Operation.DIVISION) }

        decimalButton = getView()!!.findViewById(R.id.decimal_button)
        decimalButton.setOnClickListener { view114 ->
            if (!displayBuilder.toString().contains(".")) {
                addNumberToValue(".")
            }
        }

        signButton = getView()!!.findViewById(R.id.sign_button)
        signButton.setOnClickListener { view115 ->
            val signChange = stringBuilderToDouble(displayBuilder) * -1
            clearDisplay()
            displayBuilder.append(signChange)
            readOutText.text = displayBuilder
        }

        percentButton = getView()!!.findViewById(R.id.percent_button)
        percentButton.setOnClickListener { view116 ->
            if (displayBuilder.length != 0) {
                val percentage = stringBuilderToDouble(displayBuilder) / 100
                clearDisplay()
                displayBuilder.append(percentage)
                readOutText.text = displayBuilder
            }
        }

        backButton = getView()!!.findViewById(R.id.back_button)
        backButton.setOnClickListener { view117 ->
            if (displayBuilder.length != 0) {
                displayBuilder.deleteCharAt(displayBuilder.length - 1)
                readOutText.text = displayBuilder
            }
        }

        clearButton = getView()!!.findViewById(R.id.clear_button)
        clearButton.setOnClickListener { view118 ->
            calc.clear()
            clearSummaryView()
            clearDisplay()
        }
    }

    private fun clearDisplay() {
        displayBuilder.delete(0, displayBuilder.length)
        readOutText.text = ""
    }

    private fun clearSummaryView() {
        summaryText = ""
        summaryTextView.text = ""
    }

    private fun stringBuilderToDouble(displayBuilder: StringBuilder): Double {
        return if (displayBuilder.length != 0) {
            java.lang.Double.parseDouble(displayBuilder.toString())
        } else {
            0.0
        }
    }

    private fun addNumberToValue(value: String) {
        if (resetSummary) {
            clearDisplay()
            clearSummaryView()
            resetSummary = false
        }
        displayBuilder.append(value)
        readOutText.text = displayBuilder
    }

    private fun operationButtonClicked(operator: Operation) {
        if (resetSummary) {
            resetSummary = false
            summaryText = ""
        }
        calc.addConstant(stringBuilderToDouble(displayBuilder))
        calc.addOperator(operator)
        summaryText += displayBuilder.toString() + " " + operator.toString() + " "
        summaryTextView.text = summaryText
        clearDisplay()
    }

    companion object {

        fun newInstance(): MainHostActivityFragment {
            return MainHostActivityFragment()
        }
    }
}
