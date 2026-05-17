package com.ypwang.medium

import kotlin.math.pow

class Solution3932 {
    fun countKthRoots(l: Int, r: Int, k: Int): Int {
        if (k == 1)
            return r - l + 1

        var res = 0
        val maxx = r.toDouble().pow(1.0 / k).toInt() + 1
        for (x in 0..maxx) {
            val y = Math.round(x.toDouble().pow(k.toDouble()))
            if (y in l..r)
                res++
        }

        return res
    }
}
