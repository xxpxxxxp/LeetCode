package com.ypwang.hard

class Solution3519 {
    fun countNumbers(l: String, r: String, b: Int): Int {
        val MOD = 1000000007
        val lDigits = convertToBase(subtractOne(l), b)
        val rDigits = convertToBase(r, b)
        val resL = count(lDigits, MOD, b)
        val resR = count(rDigits, MOD, b)
        return (resR - resL + MOD) % MOD
    }

    private fun count(digits: IntArray, MOD: Int, base: Int): Int {
        val n = digits.size
        val dp = Array(n) { Array(base) { Array(2) { Array(2) { null as Int? } } } }
        return solve(0, 0, 1, 1, digits, dp, base, MOD)
    }

    private fun solve(pos: Int, last: Int, tight: Int, leadingZero: Int, digits: IntArray,
                      dp: Array<Array<Array<Array<Int?>>>>, base: Int, MOD: Int): Int {
        if (pos == digits.size)
            return 1

        if (dp[pos][last][tight][leadingZero] == null) {
            val limit = if (tight == 1) digits[pos] else base - 1
            var res = 0
            var d = 0

            while (d <= limit) {
                if (leadingZero == 1 || d >= last) {
                    val newLast = if (leadingZero == 1 && d == 0) 0 else d
                    val newTight = if (tight == 1 && d == limit) 1 else 0
                    val newLeadingZero = if (leadingZero == 1 && d == 0) 1 else 0
                    val a = solve(pos + 1, newLast, newTight, newLeadingZero, digits, dp, base, MOD) % MOD
                    res = (res + a) % MOD
                }
                d++
            }

            dp[pos][last][tight][leadingZero] = res
        }

        return dp[pos][last][tight][leadingZero]!!
    }

    private fun convertToBase(s: String, base: Int): IntArray {
        var len = s.length
        var num = IntArray(len) { s[it] - '0' }
        val resList = mutableListOf<Int>()

        while (len > 0) {
            var rem = 0
            val next = IntArray(len)
            var newLen = 0
            var j = 0

            while (j < len) {
                val cur = rem * 10L + num[j]
                val q = (cur / base).toInt()
                rem = (cur % base).toInt()
                if (newLen > 0 || q != 0) {
                    next[newLen] = q
                    newLen++
                }
                j++
            }
            resList.add(rem)
            num = next.copyOfRange(0, newLen)
            len = newLen
        }

        return IntArray(resList.size) { resList[resList.size - 1 - it] }
    }

    private fun subtractOne(s: String): String {
        val arr = s.toCharArray()
        var i = arr.size - 1

        while (i >= 0 && arr[i] == '0') {
            arr[i] = '9'
            i--
        }

        if (i >= 0)
            arr[i]--

        var start = 0
        while (start < arr.size && arr[start] == '0')
            start++

        return if (start == arr.size) "0" else String(arr.copyOfRange(start, arr.size))
    }
}
