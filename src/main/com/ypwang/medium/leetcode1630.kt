package com.ypwang.medium

class Solution1630 {
    fun isArithmetic(l: List<Int>): Boolean {
        if (l.size < 3) return true
        val s = l.sorted()
        var diff = Int.MIN_VALUE
        var c = s.first()

        for (v in s.drop(1)) {
            when {
                diff == Int.MIN_VALUE -> {
                    diff = v - c
                    c = v
                }
                diff != v - c -> return false
                else -> c = v
            }
        }

        return true
    }

    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> =
        l.zip(r).map { pair -> isArithmetic((pair.first..pair.second).map { nums[it] }) }
}

fun main() {
    println(Solution1630().checkArithmeticSubarrays(intArrayOf(4,6,5,9,3,7),
            intArrayOf(0,0,2),
            intArrayOf(2,3,5)))
}