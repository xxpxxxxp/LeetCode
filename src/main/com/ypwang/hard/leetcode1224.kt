package com.ypwang.hard

class Solution1224 {
    fun maxEqualFreq(nums: IntArray): Int {
        val cnt = mutableMapOf<Int, Int>()
        val freq = mutableMapOf<Int, Int>()
        var maxOccurrence = 0
        var rst = 0

        for ((i, num) in nums.withIndex()) {
            cnt[num] = cnt.getOrDefault(num, 0) + 1
            if (cnt[num]!! > 1) freq[cnt[num]!!-1] = freq[cnt[num]!!-1]!! - 1
            freq[cnt[num]!!] = freq.getOrDefault(cnt[num]!!, 0) + 1
            maxOccurrence = maxOf(maxOccurrence, cnt[num]!!)

            if (maxOccurrence * freq[maxOccurrence]!! == i
                    || (maxOccurrence > 1 && (maxOccurrence - 1) * (freq[maxOccurrence-1]!! + 1) == i)
                    || maxOccurrence == 1)
                rst = i+1
        }

        return rst
    }
}

fun main() {
    println(Solution1224().maxEqualFreq(intArrayOf(2,2,1,1,5,3,3,5)))
    println(Solution1224().maxEqualFreq(intArrayOf(1,1,1,2,2,2,3,3,3,4,4,4,5)))
    println(Solution1224().maxEqualFreq(intArrayOf(1,1,1,2,2,2)))
    println(Solution1224().maxEqualFreq(intArrayOf(10,2,8,9,3,8,1,5,2,3,7,6)))
}