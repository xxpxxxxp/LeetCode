package com.ypwang.medium

class Solution1558 {
    fun minOperations(nums: IntArray): Int =
        nums.reduce { acc, i -> acc or i }.let { common ->
            common.toString(2).length - 1 + nums.map { (it and common).toString(2).let { s -> s.count { c -> c == '1' } } }.sum()
        }
}

fun main() {
    println(Solution1558().minOperations(intArrayOf(1,5)))
    println(Solution1558().minOperations(intArrayOf(2,2)))
    println(Solution1558().minOperations(intArrayOf(4,2,5)))
    println(Solution1558().minOperations(intArrayOf(3,2,2,4)))
    println(Solution1558().minOperations(intArrayOf(2,4,8,16)))
}