package com.brazenhiker.richcalc

import android.support.test.runner.AndroidJUnit4
import com.brazenhiker.richcalc.Calcs.Calc
import com.brazenhiker.richcalc.Calcs.Operation
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

/**
 * Tests Calc class ability to function properly and calculate values
 *
 * @author martinb
 * @since 7/3/2018
 */
@RunWith(AndroidJUnit4::class)
class CalcTests {
    @Test
    fun noValue() {
        var calc = Calc()
        var result = calc.calculate()
        Assert.assertEquals(0.0, result, 0.001)
    }

    @Test
    fun singleValue() {
        var calc = Calc()
        calc.addConstant(2.0)
        calc.addOperator(Operation.ADDITION)
        var result = calc.calculate()
        Assert.assertEquals(2.0, result, 0.001)
    }

    @Test
    fun basicCalc() {
        var calc = Calc(40)
        var result = calc.calculate()
        Assert.assertEquals(40.0, result, 0.001)
    }

    @Test
    fun twoValuesAddition() {
        var calc = Calc()
        calc.addConstant(4.0)
        calc.addOperator(Operation.ADDITION)
        calc.addConstant(2.0)
        var result = calc.calculate()
        Assert.assertEquals(6.0, result,  0.001)
    }

    @Test
    fun twoValuesSubtraction() {
        var calc = Calc()
        calc.addConstant(5.0)
        calc.addOperator(Operation.SUBTRACTION)
        calc.addConstant(2.0)
        var result = calc.calculate()
        Assert.assertEquals(3.0, result,  0.001)
    }

    @Test
    fun twoValuesMultiplication() {
        var calc = Calc()
        calc.addConstant(4.0)
        calc.addOperator(Operation.MULTIPLICATION)
        calc.addConstant(2.0)
        var result = calc.calculate()
        Assert.assertEquals(8.0, result,  0.001)
    }

    @Test
    fun twoValuesDivision() {
        var calc = Calc()
        calc.addConstant(4.0)
        calc.addOperator(Operation.DIVISION)
        calc.addConstant(2.0)
        var result = calc.calculate()
        Assert.assertEquals(2.0, result,  0.001)
    }

    @Test
    fun calcThreeValues() {
        var calc = Calc()
        calc.addConstant(4.0)
        calc.addOperator(Operation.ADDITION)
        calc.addConstant(2.0)
        calc.addOperator(Operation.ADDITION)
        calc.addConstant(5.0)
        var result = calc.calculate()
        Assert.assertEquals(11.0, result,  0.001)
    }

    @Test
    fun calcFourValues() {
        var calc = Calc()
        calc.addConstant(4.0)
        calc.addOperator(Operation.ADDITION)
        calc.addConstant(5.0)
        calc.addOperator(Operation.SUBTRACTION)
        calc.addConstant(2.0)
        calc.addOperator(Operation.MULTIPLICATION)
        calc.addConstant(2.0)
        var result = calc.calculate()
        Assert.assertEquals(14.0, result,  0.001)
    }

}