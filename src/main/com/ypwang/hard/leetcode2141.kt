package com.ypwang.hard

class Solution2141 {
    fun maxRunTime(n: Int, A: IntArray): Long {
        A.sortDescending()
        var sum = A.fold(0L) { a, b -> a + b }
        var k = 0
        while (A[k] > sum / (n-k))
            sum -= A[k++]
        return sum / (n - k)
    }
}