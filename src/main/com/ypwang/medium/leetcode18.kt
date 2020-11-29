package com.ypwang.medium

class Solution18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
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

        fun find3Sum(startIndex: Int, num: Int): List<List<Int>> {
            val rst = mutableListOf<List<Int>>()
            var i = startIndex
            while (i < nums.size) {
                val t = nums[i]
                rst.addAll(findSum(i + 1, num - t).map { it + t })
                do {
                    i++
                } while (i < nums.size && nums[i] == t)
            }
            return rst
        }

        val rst = mutableListOf<List<Int>>()

        var index = 0
        while (index < nums.size) {
            val num = nums[index]
            rst.addAll(find3Sum(index + 1, target - num).map { it + num })
            do {
                index++
            } while (index < nums.size && nums[index] == num)
        }

        return rst
    }
}

fun main() {
    println(Solution18().fourSum(intArrayOf(-3,-2,-1,0,0,1,2,3), 0))
}