package com.ypwang.medium

class Solution2607 {
    fun makeSubKSumEqual(arr: IntArray, k: Int): Long {
        val n = arr.size
        val visited = BooleanArray(n)
        var total = 0L
        for (i in 0 until n) {
            if (visited[i])
                continue  // we already considered this set
            val sameValue = mutableListOf(arr[i])
            var next = (i + k) % n
            while (next != i) { // we stop when we come back to the first index
                sameValue.add(arr[next])
                visited[next] = true
                next = (next + k) % n
            }

            // find median
            sameValue.sort()
            val median = sameValue[sameValue.size / 2]

            // add differences
            for (v in sameValue) {
                total += Math.abs(v - median)
            }
        }
        return total
    }
}