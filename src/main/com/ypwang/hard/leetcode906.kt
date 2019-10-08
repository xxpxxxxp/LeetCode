package com.ypwang.hard

class Solution906 {
    fun superpalindromesInRange(L: String, R: String): Int {
        val l = L.toLong()
        val r = R.toLong()
        val magic = 100000

        var count = 0
        for (i in 1 until magic) {
            val t = OddPalindrome(i.toLong())
            val mul = t * t
            if (mul > r) break
            if (mul >= l && isPalindrome(mul)) count++
        }

        for (i in 1 until magic) {
            val t = EvenPalindrome(i.toLong())
            val mul = t * t
            if (mul > r) break
            if (mul >= l && isPalindrome(mul)) count++
        }

        return count
    }

    private fun OddPalindrome(init: Long): Long {
        var reverse = 0L
        var mul = 1L
        var cur = init

        while (cur > 0) {
            reverse = reverse * 10 + (cur % 10)
            cur /= 10
            mul *= 10
        }

         mul /= 10
        return init * mul + reverse % mul
    }

    private fun EvenPalindrome(init: Long): Long {
        var reverse = 0L
        var mul = 1L
        var cur = init

        while (cur > 0) {
            reverse = reverse * 10 + (cur % 10)
            cur /= 10
            mul *= 10
        }

        return init * mul + reverse % mul
    }

    private fun isPalindrome(l: Long): Boolean {
        var reverse = 0L
        var cur = l
        while (cur > 0) {
            reverse = reverse * 10 + (cur % 10)
            cur /= 10
        }

        return reverse == l
    }
}

fun main() {
    println(Solution906().superpalindromesInRange("1", "19028"))
}