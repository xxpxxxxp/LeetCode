package com.ypwang.medium

class MyCalendar {
    val segments = mutableListOf<Pair<Int, Int>>()
    fun book(start: Int, end: Int): Boolean {
        val index = segments.binarySearch { it.first - start }
        if (index >= 0) {
            return false
        }

        val real = -index - 1
        if ((real >= segments.size || (segments[real].first >= end)) && (real == 0 || segments[real-1].second <= start)) {
            segments.add(real, Pair(start, end))
            return true
        }

        return false
    }
}

fun main() {
    val calender = MyCalendar()
    println(calender.book(10, 20))
    println(calender.book(15, 25))
    println(calender.book(20,30))
}