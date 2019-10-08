package com.ypwang.hard

class Solution335 {
    fun isSelfCrossing(x: IntArray): Boolean =
        (3 until x.size).any { i ->
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3])
                true
            else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
                true
            else i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]
        }
}