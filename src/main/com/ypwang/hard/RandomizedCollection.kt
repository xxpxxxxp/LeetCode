package com.ypwang.hard

import java.util.*

class RandomizedCollection {
    /** Initialize your data structure here. */
    private val cache = ArrayList<Int>()
    private var size = 0
    private val idxMap = mutableMapOf<Int, MutableSet<Int>>()
    private val rand = Random()

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (cache.size == size) cache.add(`val`)
        else cache[size] = `val`

        val rst = `val` !in idxMap
        if (rst) idxMap[`val`] = mutableSetOf()
        idxMap[`val`]!!.add(size)

        size++

        return rst
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (`val` !in idxMap || idxMap[`val`]!!.isEmpty()) return false

        val ids = idxMap[`val`]!!
        val idx = ids.last()
        ids.remove(idx)
        if (ids.isEmpty()) idxMap.remove(`val`)

        if (idx != size-1) {
            // take the last to here
            val last = size-1
            idxMap[cache[last]]!!.remove(last)
            cache[idx] = cache[last]
            idxMap[cache[last]]!!.add(idx)
        }
        size--

        return true
    }

    /** Get a random element from the collection. */
    fun getRandom(): Int {
        return cache[rand.nextInt(size)]
    }
}

fun main() {
    val r = RandomizedCollection()
    println(r.insert(0))
    println(r.insert(1))
    println(r.remove(0))
    println(r.insert(2))
    println(r.remove(1))
    println(r.getRandom())
}