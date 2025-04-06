package com.ypwang.hard

class Solution3509 {
    val MIN = -5000

    fun maxProduct(nums: IntArray, k: Int, limit: Int): Int {
        val sum = nums.sum()
        val dp = mutableMapOf<Int, MutableMap<Int, MutableMap<Int, MutableMap<Int, Int>>>>()

        fun recursion(pos: Int, currSum: Int, product: Int, isOdd: Int): Int {
            if (pos == nums.size)
                return if (currSum == k && isOdd != 0 && product <= limit) product else MIN

            if (dp[pos]?.get(currSum)?.get(product)?.containsKey(isOdd) == true)
                return dp[pos]!![currSum]!![product]!![isOdd]!!

            var ans = recursion(pos + 1, currSum, product, isOdd)

            when (isOdd) {
                0 ->
                    ans = maxOf(ans, recursion(pos + 1, currSum + nums[pos], nums[pos], 2))
                1 ->
                    ans = maxOf(ans, recursion(pos + 1, currSum + nums[pos], minOf(product * nums[pos], limit + 1), 2))
                2 ->
                    ans = maxOf(ans, recursion(pos + 1, currSum - nums[pos], minOf(product * nums[pos], limit + 1), 1))
            }

            dp.getOrPut(pos) { mutableMapOf() }
                .getOrPut(currSum) { mutableMapOf() }
                .getOrPut(product) { mutableMapOf() }[isOdd] = ans

            return ans
        }

        if (k > sum || k < -sum)
            return -1

        val ans = recursion(0, 0, 0, 0)
        return if (ans == MIN) -1 else ans
    }
}
