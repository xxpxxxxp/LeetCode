package com.ypwang.medium

class Solution2261 {
    fun countDistinct(nums: IntArray, k: Int, p: Int): Int {
        val hs = mutableSetOf<String>()
        for (i in nums.indices) {
            var cnt = 0
            val sb = StringBuilder()
            for (j in i until nums.size) {
                if (nums[j] % p == 0)
                    cnt++
                if (cnt > k)
                    break
                sb.append(nums[j])
                sb.append(",")
                hs.add(sb.toString())
            }
        }
        return hs.size
    }
}