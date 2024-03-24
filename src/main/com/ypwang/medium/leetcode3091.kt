package com.ypwang.medium

class Solution3091 {
    fun minOperations(k: Int): Int {
        var l = 0
        var r = 1000

        while (l < r) {
            val mid = (l + r) / 2
            val inc = (mid - 1) / 2
            val v = (1 + inc) * (mid + 1 - inc)

            if (v >= k)
                r = mid
            else
                l = mid + 1
        }

        return l
    }
}

fun main() {
    println(Solution3091().minOperations(11))
    println(Solution3091().minOperations(1))
}
