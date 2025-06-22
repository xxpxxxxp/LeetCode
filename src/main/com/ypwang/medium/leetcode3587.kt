package com.ypwang.medium

class Solution3587 {
    fun minSwaps(nums: IntArray): Int {
        val (o, e) = nums.withIndex().partition { it.value % 2 == 0 }
        if (Math.abs(o.size - e.size) > 1)
            return -1

        if (nums.size % 2 == 1) {
            val m = if (o.size > e.size) o else e
            return (0 until nums.size step 2).zip(m).sumOf { (i, p) -> Math.abs(p.index - i) }
        }

        return minOf(
            (0 until nums.size step 2).zip(o).sumOf { (i, p) -> Math.abs(p.index - i) },
            (0 until nums.size step 2).zip(e).sumOf { (i, p) -> Math.abs(p.index - i) }
        )
    }
}

fun main() {
    println(Solution3587().minSwaps(intArrayOf(2,4,6,5,7)))
    println(Solution3587().minSwaps(intArrayOf(2,4,5,7)))
    println(Solution3587().minSwaps(intArrayOf(1,2,3)))
    println(Solution3587().minSwaps(intArrayOf(4,5,6,8)))
}