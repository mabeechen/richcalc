package com.brazenhiker.richcalc.Calcs

/**
 * Stores and calculates values entered into a calculator
 *
 * @author martinb
 * @since 7/3/2018
 */
class Calc(value: Double? = null) {

    private var leftOperand: Calc? = null
    private var rightOperand: Double? = value
    private var operation = Operation.UNKNOWN

    constructor(intValue: Int) : this(intValue.toDouble())

    /**
     * Calculate the operands and return the final value
     *
     * @return The computed value of the operands
     */
    fun calculate(): Double {
        var result = 0.0
        var left = leftOperand?.calculate() ?: 0.0
        var right = rightOperand
                ?: if (operation == Operation.MULTIPLICATION || operation == Operation.DIVISION) 1.0 else 0.0

        result = when (this.operation) {
            Operation.ADDITION -> left + right
            Operation.SUBTRACTION -> left - right
            Operation.MULTIPLICATION -> left * right
            Operation.DIVISION -> left / right
            Operation.UNKNOWN -> right
        }
        return result
    }

    fun addConstant(constant: Double) {
        when {
            leftOperand == null -> leftOperand = Calc(constant)
            rightOperand == null -> rightOperand = constant
            else -> {
                leftOperand = Calc(calculate())
                rightOperand = null
                operation = Operation.UNKNOWN
            }
        }
    }

    fun addOperator(operator: Operation) {
        when {
            leftOperand == null -> return
            rightOperand == null -> operation = operator
            else -> {
                leftOperand = Calc(calculate())
                rightOperand = null
                operation = operator
            }
        }
    }

    fun clear() {
        leftOperand = null
        rightOperand = null
        operation = Operation.UNKNOWN
    }
}

/**
 * Supported operators that can act on operands
 */
enum class Operation {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("%"),
    UNKNOWN("#");

    private var representation = String()
    private constructor(rep: String) {
        representation = rep;
    }

    override fun toString(): String {
        return representation
    }
}