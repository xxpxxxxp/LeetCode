package com.ypwang.hard

class Solution2488 {
    fun countSubarrays(nums: IntArray, k: Int): Int {
        val cnt = mutableMapOf<Int, Int>()
        cnt[0] = 1
        var ans = 0
        var runningBalance = 0
        var found = false
        for (num in nums) {
            if (num < k)
                --runningBalance
            else if (num > k)
                ++runningBalance
            else
                found = true

            if (found)
                ans += cnt.getOrDefault(runningBalance, 0) + cnt.getOrDefault(runningBalance - 1, 0)
            else
                cnt.merge(runningBalance, 1) { a, b -> a + b }
        }
        return ans
    }
}

fun main() {
    println(Solution2488().countSubarrays(intArrayOf(10,3,8,5,6,7,2,9,4,1), 9))
    println(Solution2488().countSubarrays(intArrayOf(3,2,1,4,5), 4))
}