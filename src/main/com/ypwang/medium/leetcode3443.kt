package com.ypwang.medium

class Solution3443 {
    private

    fun maxDistance(s: String, k: Int): Int {
        fun check(ver: Char, hor: Char): Int {
            var rst = 0
            var curr = 0
            var remainingK = k

            for (i in s.indices) {
                if (s[i] == ver || s[i] == hor) {
                    if (remainingK > 0) {
                        remainingK--
                        curr++
                    } else {
                        curr--
                    }
                } else {
                    curr++
                }
                rst = maxOf(rst, curr)
            }
            return rst
        }

        return maxOf(
            check('N', 'E'),
            check('N', 'W'),
            check('S', 'E'),
            check('S', 'W'),
        )
    }
}
