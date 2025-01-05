package com.ypwang.hard

class Solution3410 {
    fun maxSubarraySum(nums: IntArray): Long {
        val pre = mutableMapOf<Int, Long>()
        var res = nums[0].toLong()
        var prefix = 0L
        var low = 0L
        pre[0] = 0L

        for (n in nums) {
            prefix += n
            res = maxOf(res, prefix - low)

            if (n < 0) {
                pre[n] =
                    if (n in pre)
                        minOf(pre[n]!!, pre[0]!!) + n
                    else
                        pre[0]!! + n
                low = minOf(low, pre[n]!!)
            }

            pre[0] = minOf(pre[0]!!, prefix)
            low = minOf(low, pre[0]!!)
        }

        return res
    }
}
