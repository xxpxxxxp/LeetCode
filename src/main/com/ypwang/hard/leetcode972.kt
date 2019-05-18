package com.ypwang.hard

class Solution972 {
    class Rational(upper: Long, down: Long) {
        private val numerator: Long
        private val denominator: Long

        companion object {
            fun gcd(a: Long, b: Long): Long {
                if (a == 0L) return b
                if (a > b) return gcd(b, a)
                else return gcd(b % a, a)
            }
        }

        init {
            val gcd = gcd(upper, down)
            numerator = upper / gcd
            denominator = down / gcd
        }

        operator fun plus(that: Rational): Rational {
            return Rational(this.numerator * that.denominator + that.numerator * this.denominator, this.denominator * that.denominator)
        }

        override fun equals(other: Any?): Boolean {
            if (other == null) return false
            if (other is Rational) {
                return this.numerator == other.numerator && this.denominator == other.denominator
            }
            return false
        }
    }

    fun parseIntPart(integer: String): Rational {
        var intPart = 0

        for (i in 0 until integer.length) {
            if (integer[i] != '.') {
                intPart = intPart * 10 + (integer[i] - '0')
            } else {
                return Rational(intPart.toLong(), 1) + parseFloatPart(integer.substring(i+1))
            }
        }

        return Rational(intPart.toLong(), 1)
    }

    fun parseFloatPart(float: String): Rational {
        var floatPart = 0
        var floatPoint = 1

        for (i in 0 until float.length) {
            if (float[i] != '(') {
                floatPoint *= 10
                floatPart = floatPart * 10 + (float[i] - '0')
            } else {
                return Rational(floatPart.toLong(), floatPoint.toLong()) + parseInifinitPart(float.substring(i+1, float.lastIndex), floatPoint)
            }
        }

        return Rational(floatPart.toLong(), floatPoint.toLong())
    }

    fun parseInifinitPart(float: String, divide: Int): Rational {
        var infinitPart = 0
        var infinitPoint = 1

        for (c in float) {
            infinitPoint *= 10
            infinitPart = infinitPart * 10 + (c - '0')
        }

        return Rational(infinitPart.toLong(), (infinitPoint - 1) * divide.toLong())
    }

    fun isRationalEqual(S: String, T: String): Boolean {
        return parseIntPart(S) == parseIntPart(T)
    }
}

fun main() {
    println(Solution972().isRationalEqual("1414.1414(14)","1414.14(1414)"))
}