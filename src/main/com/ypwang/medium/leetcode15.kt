package com.ypwang.medium

class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return listOf()
        }

        nums.sort()

        fun findSum(startIndex: Int, num: Int): List<List<Int>> {
            var start = startIndex
            var end = nums.lastIndex

            val rst = mutableListOf<List<Int>>()

            while (start < end) {
                val startN = nums[start]
                val endN = nums[end]
                val sum = startN + endN
                when {
                    sum == num -> {
                        rst.add(listOf(startN, endN))
                        do {
                            start++
                        } while (start < nums.size && nums[start] == startN)
                        do {
                            end--
                        } while (end >= 0 && nums[end] == endN)
                    }
                    sum > num -> do {
                        end--
                    } while (end >= 0 && nums[end] == endN)
                    else -> do {
                        start++
                    } while (start < nums.size && nums[start] == startN)
                }
            }
            return rst
        }

        val rst = mutableListOf<List<Int>>()

        var index = 0
        while (index < nums.size) {
            val num = nums[index]
            rst.addAll(findSum(index + 1, -num).map { it + num })
            do {
                index++
            } while (index < nums.size && nums[index] == num)
        }

        return rst
    }
}

fun main() {
    println(Solution15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}