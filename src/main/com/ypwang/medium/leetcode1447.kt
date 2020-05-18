package com.ypwang.medium

class Solution1447 {
    private fun gcd(a: Int, b: Int): Int {
        return if (a == 0) b else gcd(b % a, a)
    }

    fun simplifiedFractions(n: Int): List<String> {
        val rst = mutableListOf<String>()

        for (i in 2..n) {
            for (j in 1 until i) {
                if (gcd(j, i) == 1)
                    rst.add("$j/$i")
            }
        }

        return rst
    }
}