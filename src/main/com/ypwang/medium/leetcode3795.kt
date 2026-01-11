package com.ypwang.medium

class Solution3795 {
    fun minLength(nums: IntArray, k: Int): Int {
        var k = k
        val cnt = mutableMapOf<Int, Int>()
        var i = 0
        val n = nums.size
        var res = n + 1
        for ((j, a) in nums.withIndex()) {
            cnt[a] = cnt.getOrDefault(a, 0) + 1
            if (cnt[a] == 1)
                k -= a

            while (k <= 0) {
                res = minOf(res, j - i + 1)
                cnt[nums[i]] = cnt[nums[i]]!! - 1
                if (cnt[nums[i]] == 0)
                    k += nums[i]
                i++
            }
        }
        return if (res > n) -1 else res
    }
}

fun main() {
    println(Solution3795().minLength(intArrayOf(2,2,3,1), 4))
}