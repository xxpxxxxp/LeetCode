package com.ypwang.easy

class Solution3688 {
    fun evenNumberBitwiseORs(nums: IntArray): Int =
        nums.filter { it % 2 == 0 }.fold(0) { a, b -> a or b }
}
