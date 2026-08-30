package com.ypwang.medium

class Solution4036 {
    fun largestString(nums: IntArray): Array<String> =
        nums.map {
            var n = it
            val rst = StringBuilder()
            for (i in 25 downTo 0) {
                val c = 1 shl i
                repeat(n / c) { rst.append('a' + i) }
                n %= c
            }
            rst.toString()
        }.toTypedArray()
}

fun main() {
    println(Solution4036().largestString(intArrayOf(2,5,7)).toList())
}
