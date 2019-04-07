package com.ypwang.medium

class Solution1014 {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        fun helper(buck: Int): Boolean {
            var count = 1
            var curSum = 0

            for (w in weights) {
                if (w > buck)
                    return false

                if (curSum + w > buck) {
                    curSum = w
                    count++
                } else {
                    curSum += w
                }
            }

            return count <= D
        }

        var l = weights.sum() / D
        var r = Math.ceil(weights.size.toDouble() * weights.max()!! / D).toInt()

        while (l < r) {
            val mid = (l + r) / 2
            if (helper(mid)) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return l
    }
}

fun main() {
    println(Solution1014().shipWithinDays(intArrayOf(1,2,3,4,5,6,7,8,9,10), 5))
}