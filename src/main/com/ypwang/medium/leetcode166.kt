package com.ypwang.medium

import java.lang.StringBuilder

class Solution166 {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val flag = if ((numerator >= 0 && denominator > 0) || (numerator <= 0 && denominator < 0)) "" else "-"
        val pnumerator = Math.abs(numerator.toLong())
        val pdenominator = Math.abs(denominator.toLong())

        val integer = pnumerator / pdenominator

        val rest = pnumerator - integer * pdenominator

        if (rest == 0L)
            return flag + integer.toString()

        val float = LinkedHashMap<Long, Long>()

        var r = rest
        do {
            val m = r * 10 / pdenominator
            float[r] = m
            r = r * 10 - m * pdenominator
        } while (r != 0L && r != rest && r !in float)

        return flag +
                when (r) {
                    0L -> "$integer.${ float.values.joinToString("") }"
                    rest -> "$integer.(${ float.values.joinToString("") })"
                    in float -> {
                        StringBuilder().apply {
                            append(integer)
                            append(".")
                            for ((k, v) in float) {
                                if (k == r)
                                    append("(")

                                append(v)
                            }
                            append(")")
                        }.toString()
                    }
                    else -> ""
                }
    }
}

fun main(args: Array<String>) {
    println(Solution166().fractionToDecimal(-2147483648, 1))
}