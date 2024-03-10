package com.ypwang.easy

class Solution3074 {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        var s = apple.sum()
        capacity.sortDescending()
        for ((i, n) in capacity.withIndex()) {
            s -= n
            if (s <= 0)
                return i+1
        }

        return 0
    }
}
