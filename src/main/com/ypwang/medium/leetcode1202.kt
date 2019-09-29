package com.ypwang.medium

class Solution1202 {
    data class DSU(val `val`: Int) {
        var parent = this

        fun findParent(): DSU {
            if (parent != this) parent = parent.findParent()
            return parent
        }

        fun union(that: DSU) {
            this.findParent().parent = that.findParent()
        }
    }

    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        val pos = pairs.flatten().toSet()
        val dsus = pos.map { it to DSU(it) }.toMap()

        for ((a, b) in pairs) {
            dsus[a]!!.union(dsus[b]!!)
        }

        val rst = s.toCharArray()
        val cache = mutableMapOf<Int, Pair<MutableList<Char>, MutableList<Int>>>()

        for (p in pos.sorted()) {
            val head = dsus[p]!!.findParent().`val`
            if (head !in cache) cache[head] = mutableListOf<Char>() to mutableListOf<Int>()

            cache[head]!!.first.add(s[p])
            cache[head]!!.second.add(p)
        }

        for ((_, ps) in cache) {
            ps.first.sorted().zip(ps.second).forEach { (c, i) ->
                rst[i] = c
            }
        }

        return rst.joinToString("")
    }
}

fun main() {
    println(Solution1202().smallestStringWithSwaps("dcab", listOf(listOf(0, 3), listOf(1, 2))))
    println(Solution1202().smallestStringWithSwaps("dcab", listOf(listOf(0, 3), listOf(1, 2), listOf(0, 2))))
    println(Solution1202().smallestStringWithSwaps("cba", listOf(listOf(0, 1), listOf(1, 2))))
}