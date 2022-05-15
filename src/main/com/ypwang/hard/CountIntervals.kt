package com.ypwang.hard

import java.util.*

class CountIntervals {
    // Interval treemap start -> finish.
    private val s = TreeMap<Int, Int>()
    private var count = 0

    fun add(left: Int, right: Int) {
        // Add interval if there is no overlapping.
        if (s.floorKey(right) == null || s[s.floorKey(right)]!! < left) {
            s[left] = right
            count += (right - left + 1)
        } else {
            var start = left
            var end = right

            // Remove overlapping intervals and update count.
            while (true) {
                val l = s.floorKey(end)
                val r = s[l]!!
                start = minOf(start, l)
                end = maxOf(end, r)
                count -= (r - l + 1)
                s.remove(l)
                // Break the loop until there is no overlapping with interval (start, end).
                if (s.floorKey(end) == null || s[s.floorKey(end)]!! < start) {
                    break
                }
            }
            // Add (start, end) to TreeMap and update count.
            s[start] = end
            count += (end - start + 1)
        }
    }

    fun count(): Int = count
}