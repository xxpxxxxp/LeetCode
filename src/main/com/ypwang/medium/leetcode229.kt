package com.ypwang.medium

class Solution229 {
    fun majorityElement(nums: IntArray): List<Int> {
        var firstC = 0
        var secondC = 0
        var first = 0
        var second = 0

        for (num in nums) {
            when {
                (firstC > 0 && num == first) -> firstC++
                (secondC > 0 && num == second) -> secondC++
                firstC == 0 -> {
                    first = num
                    firstC = 1
                }
                secondC == 0 -> {
                    second = num
                    secondC++
                }
                else -> {
                    firstC--
                    secondC--
                }
            }
        }

        firstC = 0
        secondC = 0
        for (num in nums) {
            if (num == first) firstC++
            else if (num == second) secondC++
        }
        val rst = mutableListOf<Int>()
        if (firstC > nums.size / 3) rst.add(first)
        if (secondC > nums.size / 3) rst.add(second)
        return rst
    }
}

fun main() {
    println(Solution229().majorityElement(intArrayOf(1,2,2,3,2,1,1,3)))
}