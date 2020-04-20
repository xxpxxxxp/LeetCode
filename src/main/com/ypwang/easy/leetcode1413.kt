package com.ypwang.easy

class Solution1413 {
    fun minStartValue(nums: IntArray): Int =
            nums.fold(1 to 0) { (rst, sum), it ->
                val t = sum + it
                maxOf(1 - t, rst) to t
            }.first
}