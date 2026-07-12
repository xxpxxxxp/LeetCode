package com.ypwang.easy

class Solution1986 {
    fun secondsBetweenTimes(startTime: String, endTime: String): Int {
        fun convert(s: String): Int {
            val (h, m, s) = s.split(":")
            return h.toInt() * 3600 + m.toInt() * 60 + s.toInt()
        }

        return convert(endTime) - convert(startTime)
    }
}
