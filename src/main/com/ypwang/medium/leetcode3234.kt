package com.ypwang.medium

class Solution3234 {
    fun numberOfSubstrings(s: String): Int {
        val n = s.length
        var rst = 0

        for (k in 1..Math.sqrt(n.toDouble()).toInt()) {
            val zeros = mutableListOf<Int>()
            var lastZero = -1
            var ones = 0

            for (i in 0 until n) {
                if (s[i] == '0') {
                    zeros.add(i)
                    while (zeros.size > k) {
                        ones -= zeros.first() - lastZero - 1
                        lastZero = zeros.removeFirst()
                    }
                } else
                    ones++

                if (zeros.size == k && ones >= k * k)
                    rst += minOf(zeros.first() - lastZero, ones - k * k + 1)
            }
        }

        // Handle all-ones substrings
        var i = 0
        while (i < n) {
            if (s[i] == '0') {
                i++
                continue
            }
            var sz = 0
            while (i < n && s[i] == '1') {
                sz++
                i++
            }
            rst += sz * (sz + 1) / 2
        }

        return rst
    }
}
