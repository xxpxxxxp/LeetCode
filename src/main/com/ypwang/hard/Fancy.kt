package com.ypwang.hard


class Fancy {
    private val mod = 1000000007
    private val ids = mutableListOf<Pair<Int, Int>>()
    private val steps = mutableListOf<Int>()

    fun append(`val`: Int) {
        ids.add(`val` to steps.size)
    }

    fun addAll(inc: Int) {
        steps.add(inc)
    }

    fun multAll(m: Int) {
        steps.add(-m)
    }

    fun getIndex(idx: Int): Int {
        if (idx >= ids.size)
            return -1

        var (i, v) = ids[idx]

        for (j in v until steps.size) {
            val s = steps[j]
            i = if (s > 0) (i + s) % mod else ((i.toLong() * (-s)) % mod).toInt()
        }

        ids[idx] = i to steps.size
        return i
    }
}