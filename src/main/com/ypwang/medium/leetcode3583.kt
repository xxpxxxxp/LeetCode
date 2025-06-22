package com.ypwang.medium

class Solution3583 {
    fun specialTriplets(nums: IntArray): Int {
        val count = nums.groupBy { it }.mapValues { it.value.size }.toMap()

        val pre = mutableMapOf<Int, Int>()
        var rst = 0L
        for (n in nums) {
            if (2 * n in pre) {
                val p = pre[2 * n]!!
                var after = count[2 * n]!! - p
                if (n == 0)
                    after -= 1
                rst = (rst + p.toLong() * after) % 1000000007
            }

            pre[n] = 1 + pre.getOrDefault(n, 0)
        }

        return rst.toInt()
    }
}
