package com.ypwang.easy

class Solution2427 {
    fun commonFactors(a: Int, b: Int): Int {
        val gcd = gcd(a, b)
        var res = 0
        for (i in 1..gcd)
            if (gcd % i == 0)
                res++
        return res
    }

    fun gcd(a: Int, b: Int): Int {
        return if (a == 0) b else gcd(b % a, a)
    }
}