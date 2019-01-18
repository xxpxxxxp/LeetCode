package com.ypwang.easy

class RecentCounter {
    private var cache = mutableListOf<Int>()


    fun ping(t: Int): Int {
        cache.add(t)
        val index = cache.indexOfFirst { it >= (t - 3000) }
        cache = cache.drop(index).toMutableList()
        return cache.size
    }
}