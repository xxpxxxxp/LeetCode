package com.ypwang.medium

class Solution2232 {
    fun minimizeResult(expression: String): String {
        val (left, right) = expression.split("+")
        var min = Int.MAX_VALUE
        var result = "($expression)"
        for (i in left.indices) { //Index at which we add `(`  for left
            val leftMul = if (left.substring(0, i) == "") 1 else left.substring(0, i).toInt()
            val leftNum = left.substring(i).toInt()
            for (j in 1..right.length) { //Index at which we add `)` for right
                val rightMul = if (right.substring(j) == "") 1 else right.substring(j).toInt()
                val rightNum = right.substring(0, j).toInt()
                val sum = leftMul * (leftNum + rightNum) * rightMul
                if (sum < min) {
                    min = sum
                    result = left.substring(0, i) + "(" + left.substring(i) + "+" + right.substring(0, j) + ")" + right.substring(j)
                }
            }
        }
        return result
    }
}