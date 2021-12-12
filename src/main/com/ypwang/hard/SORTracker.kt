package com.ypwang.hard

class SORTracker {
    private val locations = mutableListOf<Pair<String, Int>>()
    private val comparator = compareByDescending<Pair<String, Int>>{ it.second }.thenBy { it.first }
    private var cnt = 0

    fun add(name: String, score: Int) {
        val ele = name to score
        var idx = locations.binarySearch(ele, comparator)
        if (idx < 0) {
            idx = -idx-1
        }
        locations.add(idx, ele)
    }

    fun get(): String {
        return locations[cnt++].first
    }
}
