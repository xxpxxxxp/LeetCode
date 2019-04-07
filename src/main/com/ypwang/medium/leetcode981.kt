package com.ypwang.medium

class TimeMap() {
    /** Initialize your data structure here. */
    private val inner = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (key in inner) {
            inner[key]!!.add(Pair(timestamp, value))
        } else {
            inner[key] = mutableListOf(Pair(timestamp, value))
        }
    }

    fun get(key: String, timestamp: Int): String {
        if (key !in inner)
            return ""

        val l = inner[key]!!
        val i = l.binarySearch {
            Integer.compare(it.first, timestamp)
        }

        return when {
            i >= 0 -> l[i].second
            i == -1 -> ""
            else -> l[-i-2].second
        }
    }
}
