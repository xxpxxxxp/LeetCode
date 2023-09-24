package com.ypwang.easy

class Solution2855 {
    fun minimumRightShifts(nums: List<Int>): Int {
        val i = nums.withIndex().minBy { it.value }.index
        val n = nums.size
        val r = if (i == 0) 0 else n - i
        return if ((0 until n-1).all {
            nums[(it + i) % n] < nums[(it + i + 1) % n]
        }) r else -1
    }
}

fun main() {
    println(Solution2855().minimumRightShifts(listOf(3,4,5,1,2)))
}