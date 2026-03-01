package com.ypwang.medium

class Solution3854 {
    private fun solve(nums: IntArray, even: Boolean): IntArray {
        var op = 0
        var maxi = Int.MIN_VALUE
        var mini = Int.MAX_VALUE
        var expectEven = even

        for (num in nums) {
            if ((num % 2 != 0 && expectEven) || (num % 2 == 0 && !expectEven)) {
                op++
                maxi = maxOf(maxi, num - 1)
                mini = minOf(mini, num + 1)
            } else {
                maxi = maxOf(num, maxi)
                mini = minOf(num, mini)
            }
            expectEven = !expectEven
        }

        return intArrayOf(op, maxi - mini)
    }

    fun makeParityAlternating(nums: IntArray): IntArray {
        val n = nums.size
        if (n == 1) return intArrayOf(0, 0)

        if (nums.toSet().size == 1)
            return intArrayOf(n / 2, 1)

        val res1 = solve(nums, false)
        val res2 = solve(nums, true)

        return minOf(res1, res2, compareBy<IntArray> { it[0] }.thenBy { it[1] })
    }
}

fun main() {
    println(Solution3854().makeParityAlternating(intArrayOf(7, 7)))
}