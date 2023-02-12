package com.ypwang.medium

class Solution2563 {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        nums.sort()

        fun countLess(n: Int): Long {
            var rst = 0L
            var i = 0
            var j = nums.lastIndex
            while (i < j) {
                while (i < j && nums[i] + nums[j] >= n)
                    j--
                rst += j - i
                i++
            }

            return rst
        }

        return countLess(upper+1) - countLess(lower)
    }
}

fun main() {
    println(Solution2563().countFairPairs(intArrayOf(0,1,7,4,4,5), 3, 6))
}
