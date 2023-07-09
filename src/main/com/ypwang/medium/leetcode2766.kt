package com.ypwang.medium

class Solution2766 {
    fun relocateMarbles(nums: IntArray, moveFrom: IntArray, moveTo: IntArray): List<Int> {
        val pos = nums.toMutableSet()
        for ((i, j) in moveFrom.zip(moveTo)) {
            if (i in pos) {
                pos.remove(i)
                pos.add(j)
            }
        }
        return pos.sorted()
    }
}