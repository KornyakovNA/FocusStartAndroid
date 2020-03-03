class Calculator {
    fun calculate(expression: String): Double {
        loop@ for (operator in Operators.values()) {
            var position = expression.reversed().lastIndexOf(operator.sign)
            while (position > 0) {
                if (isOperator(operator, expression, position)) {
                    val partialExpressions = expression.split(position)
                    val left = partialExpressions[0]
                    val right = partialExpressions[1]
                    val value0 = calculate(left)
                    val value1 = calculate(right)
                    val res = when (operator) {
                        Operators.PLUS -> value0 + value1
                        Operators.MINUS -> value0 - value1
                        Operators.DIVISION -> {
                            if (value1 == 0.0)
                                throw ArithmeticException("На ноль делить нельзя!!!")
                            value0 / value1
                        }
                        Operators.MULTIPLY -> value0 * value1
                    }
                    return res
                }
                if (position > 0) {
                    position =
                        expression.substring(0, position).reversed().lastIndexOf(operator.sign)
                }
            }
        }

        if (expression.startsWith('(') && expression.endsWith(')')) {
            return calculate(expression.substring(1, expression.lastIndex))
        }
        return (expression.toDouble())
    }

    private fun String.split(position: Int) =
        listOf(
            this.substring(0, position),
            this.substring(position + 1, this.length)
        )

    private fun String.lastIndexOf(char: Char): Int {
        var bOpen = 0     // count for open bracket
        var bClose = 0    // count for close bracket
        for (i in this.indices) {
            val currChar = this[i]

            when {
                currChar == char && bOpen == bClose ->
                    return this.length - i - 1
                currChar == '(' -> bOpen++
                currChar == ')' -> bClose++
            }
        }
        return -1
    }

    private fun isOperator(operator: Operators, expression: String, position: Int): Boolean {
        if (operator == Operators.MINUS) {
            if (position == 0) {
                return false
            } else {
                val prevOperator = expression[position - 1]
                for (legalOp in Operators.values()) {
                    if (prevOperator == legalOp.sign)
                        return false
                }
                return true
            }
        }
        return true
    }
}