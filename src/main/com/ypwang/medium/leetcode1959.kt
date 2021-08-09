package com.ypwang.medium

class Solution1959 {
    fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
        val n = nums.size
        val inf = 200 * 1000000
        val cache = Array(n){ IntArray(k+1) {-1} }

        fun dp(i: Int, k: Int): Int {
            if (i == n)
                return 0

            if (k < 0)
                return inf

            if (cache[i][k] == -1) {
                var ans = inf
                var max = Int.MIN_VALUE
                var sum = 0

                for (j in i until n) {
                    max = maxOf(max, nums[j])
                    sum += nums[j]
                    val wasted = max * (j - i + 1) - sum
                    ans = minOf(ans, dp(j+1, k-1) + wasted)
                }

                cache[i][k] = ans
            }

            return cache[i][k]
        }

        return dp(0, k)
    }
}