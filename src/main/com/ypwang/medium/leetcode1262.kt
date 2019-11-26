package com.ypwang.medium

class Solution1262 {
    fun maxSumDivThree(nums: IntArray): Int =
        nums.fold(intArrayOf(0, Int.MIN_VALUE, Int.MIN_VALUE)){ cur, num ->
            when (num % 3) {
                0 -> intArrayOf(cur[0] + num, cur[1] + num, cur[2] + num)
                1 -> intArrayOf(maxOf(cur[0], cur[2]+num), maxOf(cur[1], cur[0]+num), maxOf(cur[2], cur[1]+num))
                2 -> intArrayOf(maxOf(cur[0], cur[1]+num), maxOf(cur[1], cur[2]+num), maxOf(cur[2], cur[0]+num))
                else -> intArrayOf()
            }
        }.first()
}

fun main() {
    println(Solution1262().maxSumDivThree(intArrayOf(3,6,5,1,8)))
    println(Solution1262().maxSumDivThree(intArrayOf(4)))
    println(Solution1262().maxSumDivThree(intArrayOf(1,2,3,4,4)))
}