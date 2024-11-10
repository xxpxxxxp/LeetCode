package com.ypwang.medium

class Solution3315 {
    fun minBitwiseArray(nums: List<Int>): IntArray =
        nums.map {
            if (it == 2)
                -1
            else {
                val t = it.toString(2).toCharArray()
                var i = t.lastIndex
                while (i > 0) {
                    if (t[i-1] == '0')
                        break
                    i--
                }
                t[i] = '0'
                String(t).toInt(2)
            }
        }.toIntArray()
}

fun main() {
    println(Solution3315().minBitwiseArray(listOf(2,3,5,7)).toList())
}