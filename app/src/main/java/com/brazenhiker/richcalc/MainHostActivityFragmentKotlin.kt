package com.brazenhiker.richcalc

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.brazenhiker.richcalc.Calcs.Calc
import kotlinx.android.synthetic.main.fragment_main_host.*
import java.lang.StringBuilder

class MainHostActivityFragmentKotlin : Fragment() {

    var resetSummary = false
    var displayBuilder = StringBuilder()
    var summaryText = ""
    var calc = Calc()

    var newInstance : MainHostActivityFragmentKotlin = MainHostActivityFragmentKotlin()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
            return inflater!!.inflate(R.layout.fragment_main_host, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var readOutText = view?.findViewById<TextView>(R.id.readOutText)
        var summaryTextView = view?.findViewById<TextView>(R.id.summaryText)
        var zeroButton = view?.findViewById<Button>(R.id.zero_button)
        zeroButton?.setOnClickListener { addNumberToValue("0") }
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

    private fun clearSummaryView() {
        summaryText = ""
    }

    private fun clearDisplay() {
        displayBuilder.delete(0,displayBuilder.length)
        readOutText.text = ""
    }
}