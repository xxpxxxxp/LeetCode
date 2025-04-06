package com.ypwang.medium

import java.util.*

import java.util.*

class Router(memoryLimit: Int) {
    private val mpp: MutableMap<List<Int>, Int> = HashMap() // to track duplicates
    private val queue: Queue<List<Int>> = LinkedList() // to store packets in FIFO order
    private val timestamps: MutableMap<Int, MutableList<Int>> = HashMap() // for timestamps tracking
    private val st: MutableMap<Int, Int> = HashMap()
    private val maxSize: Int = memoryLimit // maxSize allowed

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        val packet = listOf(source, destination, timestamp)
        // checking for duplicate
        if (mpp.containsKey(packet)) return false
        if (queue.size == maxSize) { // remove the first element if queue is full
            val res = queue.poll()
            mpp.remove(res)
            val temp = res[1]
            st[temp] = st.getOrDefault(temp, 0) + 1
        }
        queue.offer(packet)
        mpp[packet] = 1
        timestamps.computeIfAbsent(destination) { mutableListOf() }.add(timestamp)
        return true
    }

    fun forwardPacket(): IntArray {
        if (queue.isEmpty()) return intArrayOf()
        val res = queue.poll()
        mpp.remove(res)
        val temp = res[1]
        st[temp] = st.getOrDefault(temp, 0) + 1
        return intArrayOf(res[0], res[1], res[2])
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        if (!timestamps.containsKey(destination)) return 0
        val p = timestamps[destination]!!
        val temp = st.getOrDefault(destination, 0)
        val right = lowerBound(p, startTime, temp)
        val left = upperBound(p, endTime, temp)
        return left - right
    }

    private fun lowerBound(p: List<Int>, target: Int, start: Int): Int {
        var l = start
        var r = p.size
        while (l < r) {
            val mid = (l + r) / 2
            if (p[mid] < target) l = mid + 1
            else r = mid
        }
        return l
    }

    private fun upperBound(p: List<Int>, target: Int, start: Int): Int {
        var l = start
        var r = p.size
        while (l < r) {
            val mid = (l + r) / 2
            if (p[mid] <= target) l = mid + 1
            else r = mid
        }
        return l
    }
}
