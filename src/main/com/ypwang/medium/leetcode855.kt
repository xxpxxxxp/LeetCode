package com.ypwang.medium

import java.util.*

class ExamRoom(val N: Int) {
    val mates = TreeSet<Int>()

    fun seat(): Int {
        var idx = 0
        var pre = 0
        var dist = 0

        if (mates.isNotEmpty()) {
            dist = mates.first()
        }

        for (mate in mates) {
            val d = (mate - pre) / 2
            if (d > dist) {
                idx = pre + d
                dist = d
            }
            pre = mate
        }

        if (mates.isNotEmpty() && N-1 - mates.last() > dist)
            idx = N-1

        mates.add(idx)
        return idx
    }

    fun leave(p: Int) {
        mates.remove(p)
    }
}

fun main() {
    val e = ExamRoom(10)
    println(e.seat())
    println(e.seat())
    println(e.seat())
    println(e.leave(0))
    println(e.leave(4))
    println(e.seat())
    println(e.seat())
}