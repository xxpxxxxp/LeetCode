package com.ypwang.hard

class Solution2376 {
    fun countSpecialNumbers(n: Int): Int {
        val s = n.toString()
        val digits = s.length
        var ans = 0
        for (i in 1 until digits) {
            var x = 1
            var k = 9
            for (j in 0 until i-1)
                x *= k--

            ans += 9 * x
        }

        val done = BooleanArray(10)
        for (i in 0 until digits) {
            var smaller = 0
            for (j in 0 until s[i] - '0')
                if (!done[j])
                    smaller++
            if (i == 0)
                smaller--
            var aage = 1
            var rem = 10 - i - 1
            for (j in i+1 until digits) {
                aage *= rem--
            }
            ans += smaller * aage;
            if (!done[s[i] - '0'])
                done[s[i] - '0'] = true
            else
                return ans
        }
        return ans + 1
    }
}