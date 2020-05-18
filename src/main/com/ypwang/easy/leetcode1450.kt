package com.ypwang.easy

class Solution1450 {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int = startTime.zip(endTime).count { queryTime in it.first..it.second }
}