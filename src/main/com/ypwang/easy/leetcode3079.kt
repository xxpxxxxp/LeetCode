package com.ypwang.easy

class Solution3079 {
    fun sumOfEncryptedInt(nums: IntArray): Int =
        nums.map { s -> s.toString().indices.map { s.toString().max() - '0' }.joinToString("").toInt() }.sum()!!
}