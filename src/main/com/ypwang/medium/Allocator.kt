package com.ypwang.medium

import java.util.*

class Allocator(n: Int) {
    private val capacity = n
    private val id2start = HashMap<Int, MutableList<Int>>()
    private val start2end = TreeMap<Int, Int>()

    fun allocate(size: Int, mID: Int): Int {
        var ite = if (start2end.isEmpty()) null else start2end.firstKey()
        if (ite == null || ite >= size) {
            if (size > capacity) {
                return -1
            }
            start2end[0] = size
            id2start.getOrPut(mID) { mutableListOf() }.add(0)
            return 0
        }
        var nextStart = start2end.higherKey(ite)
        while (nextStart != null && nextStart - start2end[ite]!! < size) {
            ite = nextStart
            nextStart = start2end.higherKey(ite)
        }
        var ret = 0
        return if (nextStart != null || capacity - start2end[ite]!! >= size) {
            ret = start2end[ite]!!
            start2end[ret] = ret + size
            id2start.getOrPut(mID) { mutableListOf() }.add(ret)
            ret
        } else {
            -1
        }
    }

    fun free(mID: Int): Int {
        val starts = id2start[mID]
        if (starts.isNullOrEmpty())
            return 0

        var ret = 0
        for (start in starts) {
            val end = start2end[start]
            ret += end!! - start
            start2end.remove(start)
        }
        id2start.remove(mID)
        return ret
    }
}
