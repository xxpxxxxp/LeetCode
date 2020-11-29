package com.ypwang.medium

class Solution78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val rst = mutableListOf<List<Int>>()

        for (i in 0 until (1 shl nums.size)) {
            val cur = mutableListOf<Int>()
            for (j in 0 until nums.size) {
                if (i and (1 shl j) != 0) {
                    cur.add(nums[j])
                }
            }
            rst.add(cur)
        }

        return rst
    }
}

fun main() {
    println(Solution78().subsets(intArrayOf(1,2,3)))
}