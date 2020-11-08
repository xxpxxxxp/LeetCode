package com.ypwang.easy

class Solution1646 {
    fun getMaximumGenerated(n: Int): Int {
        if (n == 0) return 0

        val arr = IntArray(n+1)
        arr[1] = 1

        var max = 1
        for (i in 2..n) {
            arr[i] =
                if (i % 2 == 0)
                    arr[i / 2]
                else
                    arr[i / 2] + arr[(i+1) / 2]

            max = maxOf(max, arr[i])
        }
        return max
    }
}