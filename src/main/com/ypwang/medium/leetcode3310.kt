package com.ypwang.medium

class Solution3310 {
    fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
        val suspiciousMethods = mutableSetOf(k)
        var hasChanged = true

        while (hasChanged) {
            hasChanged = false
            for ((a, b) in invocations) {
                if (a in suspiciousMethods && b !in suspiciousMethods) {
                    suspiciousMethods.add(b)
                    hasChanged = true
                }
            }
        }

        for ((a, b) in invocations)
            if (a !in suspiciousMethods && b in suspiciousMethods)
                return Array(n) { it }.toList()

        return Array(n) { it }.filter { it !in suspiciousMethods }
    }
}
