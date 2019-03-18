package com.ypwang.medium

class Solution209 {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        var count = Int.MAX_VALUE
        val window = mutableListOf<Int>()
        var sum = 0

        for (num in nums) {
            window.add(num)
            sum += num
            if (sum >= s) {
                while (sum - window.first() >= s) {
                    sum -= window.first()
                    window.removeAt(0)
                }

                if (window.size < count)
                    count = window.size
            }
        }

        return if (count == Int.MAX_VALUE) 0 else count
    }
}

fun main() {
    println(Solution209().minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)))
}