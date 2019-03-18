package com.ypwang.medium

class Solution134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var p = 0
        var q = cost.size

        var diff = 0
        while (p < q) {
            if (diff >= 0) {
                diff += (gas[p] - cost[p])
                p++
            } else {
                diff += (gas[q-1] - cost[q-1])
                q--
            }
        }
        return if (diff >= 0) q % cost.size else -1
    }
}

fun main(args: Array<String>) {
    println(Solution134().canCompleteCircuit(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2)))
}