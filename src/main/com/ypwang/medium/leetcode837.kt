package com.ypwang.medium

class Solution837 {
    fun new21Game(N: Int, K: Int, W: Int): Double {
        if (K == 0 || K + W <= N + 1) return 1.0

        val start = DoubleArray(K+W){0.0}
        for (i in K+W-1 downTo K)
            start[i] = if (i > N) 0.0 else 1.0

        var sum = minOf(N - K + 1, W).toDouble()
        for (i in K-1 downTo 0) {
            start[i] = sum / W
            sum += start[i] - start[i+W]
        }

        return start.first()
    }
}

fun main() {
    println(Solution837().new21Game(2,2,2))
}