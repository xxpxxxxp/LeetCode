package com.ypwang.hard

class Solution3739 {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Long {
        val n = nums.size
        var pre = n + 1
        val count = LongArray(2 * n + 2)
        val acc = LongArray(2 * n + 2)
        var res = 0L
        acc[pre] = 1
        count[pre] = acc[pre]
        for (a in nums) {
            pre += if (a == target) 1 else -1
            acc[pre] = ++count[pre] + acc[pre - 1]
            res += acc[pre - 1]
        }
        return res
    }
}
