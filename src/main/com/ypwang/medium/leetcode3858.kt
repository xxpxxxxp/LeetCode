package com.ypwang.medium

class Solution3858 {
    fun minimumOR(grid: Array<IntArray>): Int {
        var res = 0
        for (bi in 20 downTo 0) {
            val b = 1 shl bi
            val mask = res or (b - 1)
            for (r in grid) {
                var mustSetBit = true
                for (a in r) {
                    if ((a and mask) == a) {
                        mustSetBit = false
                        break
                    }
                }
                if (mustSetBit) {
                    res = res or b
                    break
                }
            }
        }
        return res
    }
}
