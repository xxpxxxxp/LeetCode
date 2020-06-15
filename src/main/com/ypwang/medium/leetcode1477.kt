package com.ypwang.medium

class Solution1477 {
    fun minSumOfLengths(arr: IntArray, target: Int): Int {
        val left = IntArray(arr.size){ Int.MAX_VALUE }
        val right = IntArray(arr.size){ Int. MAX_VALUE }

        var sum = 0
        var i = 0
        var j = 0
        while (j < arr.size) {
            while (sum < target && j < arr.size) {
                sum += arr[j]
                if (j > 0)
                    left[j] = minOf(left[j-1], left[j])
                j++
            }

            while (sum > target)
                sum -= arr[i++]

            if (sum == target && j < arr.size) {
                left[j] = minOf(left[j], j - i)
                sum -= arr[i++]
            }
        }

        sum = 0
        i = arr.lastIndex
        j = arr.lastIndex
        while (j >= 0) {
            while (sum < target && j >= 0) {
                sum += arr[j]
                if (j < arr.lastIndex)
                    right[j] = minOf(right[j+1], right[j])
                j--
            }

            while (sum > target)
                sum -= arr[i--]

            if (sum == target && j >= 0) {
                right[j] = minOf(right[j], i - j)
                sum -= arr[i--]
            }
        }

        return left.drop(1).zip(right.toList()).filter { it.first != Int.MAX_VALUE && it.second != Int.MAX_VALUE }.map { it.first + it.second }.min() ?: -1
    }
}

fun main() {
    println(Solution1477().minSumOfLengths(intArrayOf(61,2,11,39,13,1,5,11,3,2,15,32,7,14,2,3,1,18,13,26,11,5,1,21,21), 74))
    println(Solution1477().minSumOfLengths(intArrayOf(64,5,20,9,1,39), 69))
    println(Solution1477().minSumOfLengths(intArrayOf(3,2,2,4,3), 3))
    println(Solution1477().minSumOfLengths(intArrayOf(7,3,4,7), 7))
    println(Solution1477().minSumOfLengths(intArrayOf(4,3,2,6,2,3,4), 6))
    println(Solution1477().minSumOfLengths(intArrayOf(5,5,4,4,5), 3))
    println(Solution1477().minSumOfLengths(intArrayOf(3,1,1,1,5,1,2,13), 3))
}