package com.ypwang.easy

class Solution1470 {
    fun shuffle(nums: IntArray, n: Int): IntArray =
        IntArray(2 * n){ if (it % 2 == 0) nums[it / 2] else nums[it / 2 + n] }
}