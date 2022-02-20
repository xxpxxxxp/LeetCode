package com.ypwang.hard

class Solution2179 {
    fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
        val pos = IntArray(nums1.size)
        for ((i, v) in nums2.withIndex())
            pos[v] = i

        val pre_a = IntArray(nums1.size)
        val pos_in_b = mutableListOf(pos[nums1.first()])

        for (i in 1 until nums1.size) {
            val v = pos[nums1[i]]
            val idx = -pos_in_b.binarySearch(v)-1
            pos_in_b.add(idx, v)
            pre_a[i] = idx
        }

        val suf_a = IntArray(nums1.size)
        pos_in_b.clear()
        pos_in_b.add(pos[nums1.last()])

        for (i in nums1.lastIndex-1 downTo 0) {
            val v = pos[nums1[i]]
            val idx = -pos_in_b.binarySearch(v)-1
            suf_a[i] = pos_in_b.size - idx
            pos_in_b.add(idx, v)
        }

        return pre_a.zip(suf_a).map { it.first.toLong() * it.second }.sum()
    }
}

fun main() {
    println(Solution2179().goodTriplets(intArrayOf(2,0,1,3), intArrayOf(0,1,2,3)))
}