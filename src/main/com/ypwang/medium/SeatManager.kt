package com.ypwang.medium

import java.util.*

class SeatManager(n: Int) {
    val available = PriorityQueue<Int>().apply {
        this.addAll(1..n)
    }

    fun reserve(): Int {
        return available.poll()
    }

    fun unreserve(seatNumber: Int) {
        available.add(seatNumber)
    }
}