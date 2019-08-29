package com.ypwang.hard

import java.util.*

class Solution710(val N: Int, val blacklist: IntArray) {
    val tmp: List<Pair<Int, Int>>
    init {
        blacklist.sort()
        val rst = mutableListOf<Pair<Int, Int>>()
        val set = blacklist.toSet()
        var i = 0
        var diff = 0
        var vidx = 0

        while (i < blacklist.size) {
            if (blacklist[i] < vidx) {
                i++
                continue
            }

            val idx = blacklist[i] - diff
            vidx = blacklist[i]
            while (vidx in set) {
                diff++
                vidx++
            }
            rst.add(idx to diff)
        }

        tmp = rst
    }

    fun pick(): Int {
        val t = Random().nextInt(N - blacklist.size)
        return t + tmp.binarySearch() { it.first - t }.let { if (it < 0) (if (-it-2 < 0) 0 else tmp[-it-2].second) else tmp[it].second }
    }
}

fun main() {
    val s = Solution710(15, intArrayOf(0,1,5,8,9,10))
    val map = mutableMapOf<Int, Int>()
    for (i in 0..100000) {
        val p = s.pick()
        map[p] = map.getOrDefault(p, 0) + 1
    }
    println(map.toSortedMap())
}