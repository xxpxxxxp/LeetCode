package com.ypwang.hard

class Solution164 {
    class Bucket {
        var used = false
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
    }

    fun maximumGap(nums: IntArray): Int {
        if (nums.size < 2) return 0

        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (num in nums) {
            if (num < min) min = num
            if (num > max) max = num
        }

        if (min == max) return 0

        val d = (max - min + nums.size - 2) / (nums.size - 1)
        val buckets = Array((max - min + d) / d){ Bucket() }

        for (num in nums) {
            val idx = (num - min) / d
            buckets[idx].used = true
            if (num < buckets[idx].min) buckets[idx].min = num
            if (num > buckets[idx].max) buckets[idx].max = num
        }

        var rst = 0
        val left = buckets.filter { it.used }.toTypedArray()
        for (i in 1 until left.size) {
            rst = maxOf(rst, left[i].min - left[i-1].max)
        }

        return rst
    }
}

fun main() {
    println(Solution164().maximumGap(intArrayOf(1,1,1,1)))
    println(Solution164().maximumGap(intArrayOf(1,10000000)))
    println(Solution164().maximumGap(intArrayOf(3,6,10,1)))
    println(Solution164().maximumGap(intArrayOf(10)))
}