package com.ypwang.hard

import java.util.*

class Solution710(val N: Int, val blacklist: IntArray) {
    init {
        blacklist.sort()
        var c = 0
        for (i in 0 until blacklist.size) {
            blacklist[i] -= c++
        }
    }

    fun pick(): Int {
        val t = Random().nextInt(N - blacklist.size)
        val r = blacklist.binarySearch(t).let { if (it >= 0) it+1 else -it-1 }
        return t + r
    }
}

fun main() {
    val s = Solution710(4, intArrayOf(0,1))
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
    println(s.pick())
}