package com.ypwang.medium

class Solution2105 {
    fun minimumRefill(plants: IntArray, capacityA: Int, capacityB: Int): Int {
        var i = 0
        var j = plants.lastIndex
        var ca = capacityA
        var cb = capacityB
        var rst = 0

        while (i < j) {
            if (ca < plants[i]) {
                ca = capacityA
                rst++
            }

            if (cb < plants[j]) {
                cb = capacityB
                rst++
            }

            ca -= plants[i++]
            cb -= plants[j--]
        }

        return rst + if (i == j && maxOf(ca, cb) < plants[i]) 1 else 0
    }
}