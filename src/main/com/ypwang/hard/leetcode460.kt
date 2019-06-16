package com.ypwang.hard

import java.util.LinkedHashSet
import java.util.HashMap

class LFUCache(val capacity: Int) {
    private val vals: HashMap<Int, Int> = HashMap()
    private val counts: HashMap<Int, Int> = HashMap()
    private val lists: HashMap<Int, LinkedHashSet<Int>> = HashMap()
    private var min = -1

    init {
        lists[1] = LinkedHashSet()
    }

    fun get(key: Int): Int {
        if (!vals.containsKey(key))
            return -1

        val count = counts[key]!!
        counts[key] = count + 1
        lists[count]!!.remove(key)
        if (count == min && lists[count]!!.size == 0)
            min++

        if (!lists.containsKey(count + 1))
            lists[count + 1] = LinkedHashSet()

        lists[count + 1]!!.add(key)
        return vals[key]!!
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0)
            return
        if (vals.containsKey(key)) {
            vals[key] = value
            get(key)
            return
        }
        if (vals.size >= capacity) {
            val evict = lists[min]!!.iterator().next()
            lists[min]!!.remove(evict)
            vals.remove(evict)
        }

        vals[key] = value
        counts[key] = 1
        min = 1
        lists[1]!!.add(key)
    }
}

fun main() {
    val cache = LFUCache(2 /* capacity */)

    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1))       // returns 1
    cache.put(3, 3)    // evicts key 2
    println(cache.get(2))       // returns -1 (not found)
    println(cache.get(3))       // returns 3.
    cache.put(4, 4)    // evicts key 1.
    println(cache.get(1))       // returns -1 (not found)
    println(cache.get(3))       // returns 3
    println(cache.get(4))       // returns 4
}