package com.ypwang.medium

import java.util.PriorityQueue

class EventManager(events: Array<IntArray>) {
    val pq = PriorityQueue(compareByDescending<IntArray> { it[1] }.thenBy { it[0] })
    var map = mutableMapOf<Int, Int>()

    init {
        for (event in events) {
            pq.offer(event)
            map[event[0]] = event[1]
        }
    }

    fun updatePriority(eventId: Int, newPriority: Int) {
        pq.offer(intArrayOf(eventId, newPriority))
        map[eventId] = newPriority
    }

    fun pollHighest(): Int {
        while (pq.isNotEmpty()) {
            val (id, priority) = pq.poll()
            if (id in map && map[id] == priority) {
                map.remove(id)
                return id
            }
        }
        return -1
    }
}
