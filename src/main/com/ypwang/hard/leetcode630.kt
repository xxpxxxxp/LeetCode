package com.ypwang.hard

import java.util.*

class Solution630 {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        courses.sortBy { it[1] }
        val queue = PriorityQueue<Int>(Comparator { a, b -> b - a })
        var time = 0

        for ((t, d) in courses) {
            if (time + t <= d) {
                queue.offer(t)
                time += t
            } else if(queue.isNotEmpty() && queue.peek() > t) {
                time -= queue.poll() - t
                queue.offer(t)
            }
        }

        return queue.size
    }
}