package com.ypwang.medium

class Solution3790 {
    fun minAllOneMultiple(k: Int): Int {
        if (k % 2 == 0 || k % 5 == 0)
            return -1

        var rem = 0
        for (i in 1..k) {
            rem = (rem * 10 + 1) % k
            if (rem == 0)
                return i
        }
        return -1
    }
}
