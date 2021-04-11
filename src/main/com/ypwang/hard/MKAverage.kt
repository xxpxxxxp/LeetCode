package com.ypwang.hard

import java.util.*

class MKAverage(private val m: Int, private val k: Int) {
    private val top = TreeMap<Int, Int>()
    private val middle = TreeMap<Int, Int>()
    private val bottom = TreeMap<Int, Int>()
    private val q: Queue<Int> = LinkedList()

    private var middleSum: Long = 0
    private var countTop = 0
    private var countBottom = 0

    fun addElement(num: Int) {
        if (q.size == m) {
            val pop = q.poll()
            when {
                top.containsKey(pop) -> {
                    remove(top, pop)
                    countTop--
                }
                middle.containsKey(pop) -> {
                    remove(middle, pop)
                    middleSum -= pop.toLong()
                }
                else -> {
                    remove(bottom, pop)
                    countBottom--
                }
            }
        }
        // insert to middle first
        add(middle, num)
        q.offer(num)
        middleSum += num.toLong()
        // move item from middle to top, to fill k slots
        while (countTop < k && !middle.isEmpty()) {
            countTop++
            middleSum -= middle.lastKey()
            add(top, remove(middle, middle.lastKey()))
        }
        // rebalance middle and top
        while (!middle.isEmpty() && !top.isEmpty() && top.firstKey() < middle.lastKey()) {
            middleSum += top.firstKey()
            add(middle, remove(top, top.firstKey()))
            middleSum -= middle.lastKey()
            add(top, remove(middle, middle.lastKey()))
        }
        // move item from middle to bottom, to fill k slots
        while (countBottom < k && !middle.isEmpty()) {
            countBottom++
            middleSum -= middle.firstKey()
            add(bottom, remove(middle, middle.firstKey()))
        }
        // rebalance middle and bottom
        while (!middle.isEmpty() && !bottom.isEmpty() && bottom.lastKey() > middle.firstKey()) {
            middleSum += bottom.lastKey()
            add(middle, remove(bottom, bottom.lastKey()))
            middleSum -= middle.firstKey()
            add(bottom, remove(middle, middle.firstKey()))
        }
    }

    private fun remove(tm: TreeMap<Int, Int>, num: Int): Int {
        tm[num] = tm[num]!! - 1
        if (tm[num] == 0) tm.remove(num)
        return num
    }

    private fun add(tm: TreeMap<Int, Int>, num: Int) {
        tm[num] = tm.getOrDefault(num, 0) + 1
    }

    fun calculateMKAverage(): Int {
        return if (q.size == m) (middleSum / (m - 2 * k)).toInt() else -1
    }
}