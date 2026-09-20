package com.ypwang.medium

class Solution4054 {
    fun shadowPairs(nums: IntArray): Long {
        var res = 0L
        val s = IntArray(nums.size)
        var k = 0
        for (a in nums) {
            var l = 0
            var r = k
            while (l < r) {
                val mid = l + (r - l) / 2
                if (s[mid] < a) l = mid + 1
                else r = mid
            }
            res += l.toLong()

            while (k > 0 && s[k - 1] > a)
                k--

            s[k++] = a
        }
        return res
    }
}
