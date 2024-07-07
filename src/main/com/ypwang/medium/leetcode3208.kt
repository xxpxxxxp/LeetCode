package com.ypwang.medium

class Solution3208 {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        var rst = 0
        var cnt = 0
        for (i in 1 .. colors.size + k) {
            if (colors[(i-1+colors.size)%colors.size] != colors[(i+colors.size)%colors.size])
                cnt++
            else
                cnt = 1

            if (cnt >= k)
                rst++
        }

        return rst
    }
}
