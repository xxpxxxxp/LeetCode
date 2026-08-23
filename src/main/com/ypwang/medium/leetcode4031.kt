package com.ypwang.medium

class Solution4031 {
    fun findDisappearedNumbers(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
        nums.sort()

        val res = mutableListOf<List<Int>>()
        var st = lower

        for (num in nums) {
            if (num !in lower..upper)
                continue

            if (num > st)
                res.add(listOf(st, num - 1))

            st = num + 1
        }

        if (st <= upper)
            res.add(listOf(st, upper))

        return res
    }
}
