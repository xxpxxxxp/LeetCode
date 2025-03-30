package com.ypwang.hard

class Solution3505 {
    fun minOperations(nums: IntArray, x: Int, k: Int): Long {
        val n = nums.size
        val dp = Array(n + 1) { LongArray(k + 1) { if (it == 0) 0 else 1L shl 40 } }

        val leftSet = sortedSetOf<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
        val rightSet = sortedSetOf<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

        for (i in 0 until x)
            leftSet.add(Pair(nums[i], i))

        for (i in 0 until x/2)
            rightSet.add(leftSet.pollLast())

        var lSum = leftSet.fold(0L) { a, b -> a + b.first }
        var rSum = rightSet.fold(0L) { a, b -> a + b.first }

        for (i in x..n) {
            val dev = rSum - lSum + (leftSet.last().first.toLong() * (leftSet.size - rightSet.size))

            for (sz in 1..k)
                dp[i][sz] = minOf(dp[i - 1][sz], dev + dp[i - x][sz - 1])

            if (i == n)
                break

            val del = Pair(nums[i - x], i - x)
            if (leftSet.contains(del)) {
                lSum -= del.first
                leftSet.remove(del)
            } else {
                rSum -= del.first
                rightSet.remove(del)
            }

            val add = Pair(nums[i], i)
            leftSet.add(add)
            lSum += add.first - leftSet.last().first
            rSum += leftSet.last().first
            rightSet.add(leftSet.pollLast())

            if (leftSet.size < rightSet.size) {
                rSum -= rightSet.first().first
                lSum += rightSet.first().first
                leftSet.add(rightSet.pollFirst())
            }
        }
        return dp[n][k]
    }
}

fun main() {
    println(Solution3505().minOperations(intArrayOf(5,-2,1,3,7,3,6,4,-1), 3, 2))
}