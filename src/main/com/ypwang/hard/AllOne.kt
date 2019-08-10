package com.ypwang.hard

class AllOne {
    private class Bucket(val `val`: Int) {
        var previous: Bucket? = null
        var next: Bucket? = null
        val contents = mutableSetOf<String>()
    }
    /** Initialize your data structure here. */
    private val map = mutableMapOf<String, Bucket>()
    private val start: Bucket
    private val end: Bucket

    init {
        start = Bucket(-1)
        end = Bucket(0)
        start.next = end
        end.previous = start
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    fun inc(key: String) {
        val t = map.containsKey(key)
        val bucket = if (t) map[key]!! else end
        // insert key to bucket before
        if (bucket.previous!!.`val` != bucket.`val`+1) {
            // insert a new bucket before this one
            val newBucket = Bucket(bucket.`val`+1)
            bucket.previous!!.next = newBucket
            newBucket.previous = bucket.previous
            newBucket.next = bucket
            bucket.previous = newBucket
        }

        bucket.previous!!.contents.add(key)
        map[key] = bucket.previous!!

        if (t) {
            // try remote current bucket
            bucket.contents.remove(key)
            if (bucket.contents.isEmpty()) {
                // remote bucket from list
                bucket.previous!!.next = bucket.next
                bucket.next!!.previous = bucket.previous
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    fun dec(key: String) {
        if (map.containsKey(key)) {
            val bucket = map[key]!!
            // try remote current bucket
            bucket.contents.remove(key)

            if (bucket.`val` > 1) {
                if (bucket.next!!.`val` != bucket.`val`-1) {
                    // insert a new bucket after this one
                    val newBucket = Bucket(bucket.`val`-1)
                    bucket.next!!.previous = newBucket
                    newBucket.next = bucket.next
                    newBucket.previous = bucket
                    bucket.next = newBucket
                }

                bucket.next!!.contents.add(key)
                map[key] = bucket.next!!
            } else {
                map.remove(key)
            }

            if (bucket.contents.isEmpty()) {
                // remote bucket from list
                bucket.previous!!.next = bucket.next
                bucket.next!!.previous = bucket.previous
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    fun getMaxKey(): String {
        return if (map.isEmpty()) ""
        else start.next!!.contents.first()
    }

    /** Returns one of the keys with Minimal value. */
    fun getMinKey(): String {
        return if (map.isEmpty()) ""
        else end.previous!!.contents.first()
    }
}

fun main() {
    val t = AllOne()
    t.inc("a")
    t.inc("a")
    println(t.getMaxKey())
    println(t.getMinKey())
    t.inc("b")
    t.dec("a")
    println(t.getMaxKey())
    println(t.getMinKey())
    t.inc("c")
    t.inc("a")
    println(t.getMaxKey())
    println(t.getMinKey())
    t.dec("b")
    t.dec("c")
    println(t.getMaxKey())
    println(t.getMinKey())
}