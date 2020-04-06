package com.ypwang.hard

class Solution1402 {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sortDescending()
        var sum = 0
        var rst = 0
        var idx = 0
        while (idx < satisfaction.size) {
            sum += satisfaction[idx++]
            if (sum < 0) break
            rst += sum
        }

        return rst
    }
}

fun main() {
    println(Solution1402().maxSatisfaction(intArrayOf(-1,-8,0,5,-9)))
    println(Solution1402().maxSatisfaction(intArrayOf(4,3,2)))
    println(Solution1402().maxSatisfaction(intArrayOf(-1,-4,-5)))
    println(Solution1402().maxSatisfaction(intArrayOf(-2,5,-1,0,3,-3)))
}