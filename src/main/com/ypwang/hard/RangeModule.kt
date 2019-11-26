package com.ypwang.hard

import java.util.*

class RangeModule {
    class Interval(val left: Int, val right: Int): Comparable<Interval> {
        override fun compareTo(that: Interval): Int =
            if (this.right == that.right) this.left - that.left else this.right - that.right
    }

    private val ranges = TreeSet<Interval>()

    fun addRange(left: Int, right: Int) {
        var l = left
        var r = right
        val iter = ranges.tailSet(Interval(0, left-1)).iterator()
        while (iter.hasNext()) {
            val iv = iter.next()
            if (right < iv.left) break
            l = minOf(l, iv.left)
            r = maxOf(r, iv.right)
            iter.remove()
        }
        ranges.add(Interval(l, r))
    }

    fun queryRange(left: Int, right: Int): Boolean {
        val iv = ranges.higher(Interval(0, left))
        return iv != null && iv.left <= left && right <= iv.right
    }

    fun removeRange(left: Int, right: Int) {
        val iter = ranges.tailSet(Interval(0, left)).iterator()
        val todo = mutableListOf<Interval>()
        while (iter.hasNext()) {
            val iv = iter.next()
            if (right < iv.left) break
            if (iv.left < left) todo.add(Interval(iv.left, left))
            if (right < iv.right) todo.add(Interval(right, iv.right))
            iter.remove()
        }
        todo.forEach{ ranges.add(it) }
    }
}

fun main() {
    val range = RangeModule()
    range.addRange(10, 20)
    range.addRange(15, 20)
    range.removeRange(14, 16)
    range.queryRange(10, 14)
    range.queryRange(13, 15)
    range.queryRange(16, 17)
}