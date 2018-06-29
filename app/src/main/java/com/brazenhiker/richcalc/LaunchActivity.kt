package com.brazenhiker.richcalc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.launcher_activity_title)
        UseCalculatorButton.setOnClickListener { openCalcActivity() }
    }

    private fun openCalcActivity() {
        var intent = Intent(this, MainHostActivity::class.java)
        startActivity(intent)
    }
}
