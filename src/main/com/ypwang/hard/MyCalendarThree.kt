package com.ypwang.hard

import java.util.*

class MyCalendarThree {
    private val delta = TreeMap<Int, Int>()
    fun book(start: Int, end: Int): Int {
        delta[start] = delta.getOrDefault(start, 0) + 1
        delta[end] = delta.getOrDefault(end, 0) - 1

        var active = 0
        var max = 0
        for (d in delta.values) {
            active += d
            if (active > max) max = active
        }

        return max
    }
}