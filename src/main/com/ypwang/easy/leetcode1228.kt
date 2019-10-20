package com.ypwang.easy

class Solution1228 {
    fun missingNumber(arr: IntArray): Int {
        // arr[left, right) contains the missing element
        var left = 0
        var right = arr.size

        val diff = (arr.last() - arr.first()) / arr.size

        while (left < right) {
            val mid = (left + right) / 2
            if (arr[mid] == arr.first() + mid * diff) left = mid + 1
            else right = mid
        }

        return arr.first() + diff * left
    }
}