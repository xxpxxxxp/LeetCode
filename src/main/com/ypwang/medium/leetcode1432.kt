package com.ypwang.medium

class Solution1432 {
    fun maxDiff(num: Int): Int {
        return num.toString().let { replaceMax(it) - replaceMin(it) }
    }

    private fun replaceMax(num: String): Int {
        for (c in num) {
            if (c != '9')
                return num.replace(c, '9').toInt()
        }

        return num.toInt()
    }

    private fun replaceMin(num: String): Int {
        if (num.first() != '1') return num.replace(num.first(), '1').toInt()
        for (i in 1 until num.length) {
            if (num[i] != '0' && num[i] != '1')
                return num.replace(num[i], '0').toInt()
        }

        return num.toInt()
    }
}

fun main() {
    println(Solution1432().maxDiff(555))
    println(Solution1432().maxDiff(9))
    println(Solution1432().maxDiff(123456))
    println(Solution1432().maxDiff(10000))
    println(Solution1432().maxDiff(9288))
    println(Solution1432().maxDiff(1101057))
}