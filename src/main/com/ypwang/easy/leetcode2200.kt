package com.ypwang.easy

class Solution2200 {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val arr = IntArray(nums.size+1)
        for ((i, v) in nums.withIndex()) {
            if (v == key) {
                arr[maxOf(0, i-k)]++
                arr[minOf(arr.lastIndex, i+k+1)]--
            }
        }

        val rst = mutableListOf<Int>()
        var counter = 0
        for (i in nums.indices) {
            counter += arr[i]
            if (counter > 0)
                rst.add(i)
        }

        return rst
    }
}

fun main() {
    println(Solution2200().findKDistantIndices(intArrayOf(3,4,9,1,3,9,5), 9, 1))
    println(Solution2200().findKDistantIndices(intArrayOf(2,2,2,2,2), 2, 2))
}