package com.ypwang.hard

class Solution3072 {
    fun resultArray(nums: IntArray): IntArray {
        val arr1 = mutableListOf(nums[0])
        val arr2 = mutableListOf(nums[1])
        val arr1Sorted = ArrayList<Int>()
        val arr2Sorted = ArrayList<Int>()

        arr1Sorted.add(nums[0])
        arr2Sorted.add(nums[1])

        for (i in 2 until nums.size) {
            val v = nums[i]
            val pos1 = binarySearch(arr1Sorted, v)
            val pos2 = binarySearch(arr2Sorted, v)
            val gc1 = arr1.size - pos1
            val gc2 = arr2.size - pos2

            if (gc1 > gc2) {
                arr1.add(v)
                arr1Sorted.add(pos1, v)
            } else if (gc2 > gc1) {
                arr2.add(v)
                arr2Sorted.add(pos2, v)
            } else if (arr2.size < arr1.size) {
                arr2.add(v)
                arr2Sorted.add(pos2, v)
            } else {
                arr1.add(v)
                arr1Sorted.add(pos1, v)
            }
        }

        return (arr1 + arr2).toIntArray()
    }

    fun binarySearch(arr: List<Int>, v: Int): Int {
        var l = 0
        var r = arr.size

        while (l < r) {
            val mid = (l + r) / 2
            if (arr[mid] <= v)
                l = mid + 1
            else
                r = mid
        }
        return l
    }
}

fun main() {
    println(Solution3072().resultArray(intArrayOf(2,38,2)).toList())
}