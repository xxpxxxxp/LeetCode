package com.ypwang.medium

import java.nio.file.Files
import java.nio.file.Paths

class Solution1283 {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        fun divide(k: Int): Int = nums.sumBy { (it + k - 1) / k }

        var left = 1
        var right = Int.MAX_VALUE - 1

        while (left < right) {
            val mid = (left + right) / 2
            val v = divide(mid)
            if (v <= threshold) right = mid
            else left = mid+1
        }

        return left
    }
}

fun main() {
    println(Solution1283().smallestDivisor(intArrayOf(1,2,5,9), 6))
}