package com.ypwang.medium

class Solution179 {
    fun largestNumber(nums: IntArray): String {
        val r = nums.map { it.toString() }.sortedWith(Comparator label@{
            a1, a2 -> (a2 + a1).compareTo(a1 + a2)
        }).joinToString("").dropWhile { it == '0' }
        return if (r.isEmpty()) "0" else r
    }
}

fun main() {
    println(Solution179().largestNumber(intArrayOf(0,0)))
}