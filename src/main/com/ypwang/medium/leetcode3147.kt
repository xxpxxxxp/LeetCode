package com.ypwang.medium

class Solution3147 {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        val seen = BooleanArray(energy.size)

        var rst = Int.MIN_VALUE
        for (j in energy.lastIndex downTo 0) {
            if (!seen[j]) {
                var i = j
                var c = 0
                while (i >= 0) {
                    c += energy[i]
                    seen[i] = true
                    i -= k
                    rst = maxOf(rst, c)
                }
            }
        }

        return rst
    }
}
