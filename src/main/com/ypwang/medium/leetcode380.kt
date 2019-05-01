package com.ypwang.medium

import java.util.*

class RandomizedSet() {
    /** Initialize your data structure here. */
    val cache = IntArray(10000){0}
    var idx = 0
    val idxMap = mutableMapOf<Int, Int>()
    val rand = Random()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (`val` in idxMap) return false
        cache[idx] = `val`
        idxMap[`val`] = idx
        idx++
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (`val` !in idxMap) return false
        idx--
        val cur = idxMap[`val`]!!
        idxMap.remove(`val`)
        if (cur != idx) {
            cache[cur] = cache[idx]
            idxMap[cache[idx]] = cur
        }
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int = cache[rand.nextInt(idx)]
}

fun main() {
    val r = RandomizedSet()
    r.insert(0)
    r.remove(0)
    r.insert(-1)
    r.remove(0)
    r.getRandom()
    r.getRandom()
    r.getRandom()
    r.getRandom()
    r.getRandom()
    r.getRandom()
    r.getRandom()
    r.getRandom()
}