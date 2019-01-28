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

    private lateinit var readOutText: TextView
    private lateinit var summaryTextView: TextView
    private var displayBuilder = StringBuilder()
    private var summaryText = ""
    private var calc = Calc()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readOutText = getView()!!.findViewById(R.id.readOutText)
        summaryTextView = getView()!!.findViewById(R.id.summaryText)

        val zeroButton: Button = getView()!!.findViewById(R.id.zero_button)
        zeroButton.setOnClickListener { addNumberToValue("0") }

        val oneButton: Button = getView()!!.findViewById(R.id.one_button)
        oneButton.setOnClickListener { addNumberToValue("1") }

        val twoButton: Button = getView()!!.findViewById(R.id.two_button)
        twoButton.setOnClickListener { addNumberToValue("2") }

        val threeButton: Button = getView()!!.findViewById(R.id.three_button)
        threeButton.setOnClickListener { addNumberToValue("3") }

        val fourButton: Button = getView()!!.findViewById(R.id.four_button)
        fourButton.setOnClickListener { addNumberToValue("4") }

        val fiveButton: Button = getView()!!.findViewById(R.id.five_button)
        fiveButton.setOnClickListener { addNumberToValue("5") }

        val sixButton: Button = getView()!!.findViewById(R.id.six_button)
        sixButton.setOnClickListener { addNumberToValue("6") }

        val sevenButton: Button = getView()!!.findViewById(R.id.seven_button)
        sevenButton.setOnClickListener { addNumberToValue("7") }

        val eightButton: Button = getView()!!.findViewById(R.id.eight_button)
        eightButton.setOnClickListener { addNumberToValue("8") }

        val nineButton: Button = getView()!!.findViewById(R.id.nine_button)
        nineButton.setOnClickListener { addNumberToValue("9") }

        val equalsButton: Button = getView()!!.findViewById(R.id.equals_button)
        equalsButton.setOnClickListener {
            resetSummary = true
            summaryText += displayBuilder.toString()
            summaryTextView.text = summaryText
            calc.addConstant(displayBuilder.toString().toDouble())
            val result = calc.calculate()
            clearDisplay()
            displayBuilder.append(result)
            readOutText.text = displayBuilder
        }

        val plusButton: Button = getView()!!.findViewById(R.id.plus_button)
        plusButton.setOnClickListener { operationButtonClicked(Operation.ADDITION) }

        val minusButton: Button = getView()!!.findViewById(R.id.minus_button)
        minusButton.setOnClickListener { operationButtonClicked(Operation.SUBTRACTION) }

        val multiplyButton: Button = getView()!!.findViewById(R.id.multiply_button)
        multiplyButton.setOnClickListener { operationButtonClicked(Operation.MULTIPLICATION) }

        val divideButton: Button = getView()!!.findViewById(R.id.divide_button)
        divideButton.setOnClickListener { operationButtonClicked(Operation.DIVISION) }

        val decimalButton: Button = getView()!!.findViewById(R.id.decimal_button)
        decimalButton.setOnClickListener {
            if (!displayBuilder.toString().contains(".")) {
                addNumberToValue(".")
            }
        }

        val signButton: Button = getView()!!.findViewById(R.id.sign_button)
        signButton.setOnClickListener {
            val signChange = (displayBuilder.toString().toDouble()) * -1
            clearDisplay()
            displayBuilder.append(signChange)
            readOutText.text = displayBuilder
        }

        val percentButton: Button = getView()!!.findViewById(R.id.percent_button)
        percentButton.setOnClickListener {
            if (this.displayBuilder.isNotEmpty()) {
                val percentage = (displayBuilder.toString().toDouble()) / 100
                clearDisplay()
                displayBuilder.append(percentage)
                readOutText.text = displayBuilder
            }
        }

        val backButton: Button = getView()!!.findViewById(R.id.back_button)
        backButton.setOnClickListener {
            if (this.displayBuilder.isNotEmpty()) {
                displayBuilder.deleteCharAt(displayBuilder.length - 1)
                readOutText.text = displayBuilder
            }
        }

        val clearButton: Button = getView()!!.findViewById(R.id.clear_button)
        clearButton.setOnClickListener {
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
        calc.addConstant(displayBuilder.toString().toDouble())
        calc.addOperator(operator)
        summaryText += displayBuilder.toString() + " " + operator.toString() + " "
        summaryTextView.text = summaryText
        clearDisplay()
    }
}