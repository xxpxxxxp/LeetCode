package com.ypwang.medium

class Solution1300 {
    fun findBestValue(arr: IntArray, target: Int): Int {
        arr.sort()

        val partialSum = IntArray(arr.size+1)
        for (i in arr.indices)
            partialSum[i+1] = partialSum[i] + arr[i]

        var left = 0
        var right = 100000

        fun eval(v: Int): Int {
            val insertPoint = arr.binarySearch(v).let { if (it < 0) -it-1 else it }
            return partialSum[insertPoint] + (arr.size - insertPoint) * v
        }

        while (left + 1 < right) {
            val mid = (left + right) / 2
            val v = eval(mid)

            if (v < target) left = mid
            else right = mid
        }

        val l = eval(left)
        val r = eval(right)

        return if (target - l <= r - target) left else right
    }
}

fun main() {
    println(Solution1300().findBestValue(intArrayOf(4,9,3), 10))
    println(Solution1300().findBestValue(intArrayOf(2,3,5), 10))
    println(Solution1300().findBestValue(intArrayOf(60864,25176,27249,21296,20204), 56803))
}