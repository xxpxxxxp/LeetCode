package com.ypwang.easy

class Solution2248 {
    fun intersection(nums: Array<IntArray>): List<Int> =
        nums.fold((1..1000).toSet()){ cur, acc -> acc.intersect(cur) }.toList().sorted()
}