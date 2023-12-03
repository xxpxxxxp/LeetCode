package com.ypwang.medium

class Solution2952 {
    fun minimumAddedCoins(coins: IntArray, target: Int): Int {
        coins.sort()
        var sum = 0
        var idx = 0
        var count = 0

        while (sum < target) {
            if (idx < coins.size && coins[idx] <= sum+1) {
                sum += coins[idx++]
            } else {
                count++
                sum = 2 * sum + 1
            }
        }

        return count
    }
}

fun main() {
    println(Solution2952().minimumAddedCoins(intArrayOf(6,4,1,9,9,2,10,7), 48))
}