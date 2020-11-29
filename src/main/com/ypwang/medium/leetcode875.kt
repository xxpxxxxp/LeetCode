package com.ypwang.medium

class Solution875 {
    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        fun helper(k: Int): Boolean = piles.map { (it - 1) / k + 1 }.sum() <= H

        var low = 1
        var high = piles.max()!!

        while (low < high) {
            val mid = (low + high) / 2
            if (!helper(mid)) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }
}

fun main() {
    println(Solution875().minEatingSpeed(intArrayOf(30,11,23,4,20), 5))
}