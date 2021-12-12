package com.ypwang.hard

class Solution2106 {
    fun maxTotalFruits(f: Array<IntArray>, startPos: Int, k: Int): Int {
        var l = 0
        while (l < f.size && f[l][0] < startPos - k)
            l++

        var sum = 0
        var rst = 0

        var r = l
        while (r < f.size && f[r][0] <= startPos + k) {
            sum += f[r][1]
            while (minOf(startPos - 2 * f[l][0] + f[r][0], 2 * f[r][0] - f[l][0] - startPos) > k)
                sum -= f[l++][1]

            rst = maxOf(rst, sum)
            r++
        }

        return rst
    }
}