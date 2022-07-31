package com.ypwang.medium

class Solution2358 {
    fun maximumGroups(grades: IntArray): Int {
        val size = grades.size

        var left = 1L
        var right = size.toLong()
        while (left < right) {
            val mid = (left + right + 1) / 2L
            if (mid * (mid + 1) / 2 > size)
                right = mid - 1
            else
                left = mid
        }

        return left.toInt()
    }
}

fun main() {
    println(Solution2358().maximumGroups(IntArray(96134)))
}