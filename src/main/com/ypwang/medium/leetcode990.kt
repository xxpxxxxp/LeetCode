package com.ypwang.medium

class Solution990 {
    class DSU(val c: Char) {
        private var parent = this

        fun getParent(): DSU {
            if (parent != this) parent = parent.getParent()
            return parent
        }

        fun union(that: DSU) {
            that.getParent().parent = parent.getParent()
        }
    }

    fun equationsPossible(equations: Array<String>): Boolean {
        val t = equations.map { Triple(it.first(), it.substring(1, 3) == "==", it.last()) }
        val mapping = mutableMapOf<Char, DSU>()

        t.filter { it.second }.forEach {
            if (it.first !in mapping) {
                mapping[it.first] = DSU(it.first)
            }
            if (it.third !in mapping) {
                mapping[it.third] = DSU(it.third)
            }
            mapping[it.first]!!.union(mapping[it.third]!!)
        }

        return t.filter { !it.second }.all { it.first != it.third && (it.first !in mapping || it.third !in mapping || mapping[it.first]!!.getParent() != mapping[it.third]!!.getParent()) }
    }
}

fun main() {
    println(Solution990().equationsPossible(arrayOf("a==b","b!=c","c==a")))
}