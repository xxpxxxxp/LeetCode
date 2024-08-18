package com.ypwang.easy

class Solution3258 {
    fun countKConstraintSubstrings(s: String, k: Int): Int {
        val n = s.length
        var count = 0
        var left = 0
        var count0 = 0
        var count1 = 0

        for (right in 0 until n) {
            if (s[right] == '0')
                count0++
            else
                count1++

            while (count0 > k && count1 > k) {
                if (s[left] == '0')
                    count0--
                else
                    count1--
                left++
            }

            count += right - left + 1
        }

        return count
    }
}
