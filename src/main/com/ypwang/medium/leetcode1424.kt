package com.ypwang.medium

class Solution1424 {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val rst = IntArray(nums.sumBy { it.size })
        var idx = 0
        val existing = IntArray(nums.size)
        var i = 0
        while (true) {
            for (j in minOf(nums.lastIndex, i) downTo 0) {
                if (existing[j] >= 0) {
                    rst[idx++] = nums[j][existing[j]++]
                    if (existing[j] >= nums[j].size) existing[j] = -1
                }
            }

            if (idx == rst.size) return rst
            i++
        }
    }
}

fun main() {
    println(Solution1424().findDiagonalOrder(listOf(
            listOf(1,2,3), listOf(4,5,6), listOf(7,8,9)
    )).toList())
}