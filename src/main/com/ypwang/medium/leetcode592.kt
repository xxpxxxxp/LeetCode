package com.ypwang.medium

import kotlin.math.absoluteValue

class Solution592 {
    class Rational(up: Int, down: Int) {
        private fun gcd(a: Int, b: Int): Int {
            return  if (b == 0) a else gcd(b, a % b)
        }
        private val c = gcd(up, down).absoluteValue
        val up: Int = up / c
        val down: Int = down / c

        fun add(that: Rational): Rational {
            return Rational(this.up * that.down + that.up * this.down  , this.down * that.down)
        }

        fun subtract(that: Rational): Rational {
            return Rational(this.up * that.down - that.up * this.down  , this.down * that.down)
        }

        override fun toString() = "$up/$down"
    }

    fun fractionAddition(expression: String): String {
        val splits = expression.withIndex().filter { it.value in setOf('+', '-') }.map { it.index }.toMutableList()
        if (splits.isEmpty() || splits.first() != 0) {
            splits.add(0, 0)
        }
        splits.add(expression.length)

        val slices = (0 until splits.lastIndex).map { expression.substring(splits[it], splits[it+1]) }

        var rst = Rational(0, 1)
        for (r in slices) {
            val parts = r.split('/')
            val up = parts[0].toInt()
            val down = parts[1].toInt()
            rst = rst.add(Rational(up, down))
        }
        return rst.toString()
    }
}

fun main(args: Array<String>) {
    println(Solution592().fractionAddition("1/3-1/2"))
}