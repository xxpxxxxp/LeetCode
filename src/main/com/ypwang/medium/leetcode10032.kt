package com.ypwang.medium

class Solution10032 {
    fun minOperations(nums: IntArray, k: Int): Int =
        nums.fold(k) { a, b -> a xor b }.countOneBits()
}