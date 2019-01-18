package com.ypwang.easy

class Solution914 {
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        val d = deck.groupBy { it }.map { it.value.size }
        if (d.size < 2) {
            return !d.isEmpty() && d[0] > 1
        }
        val min = d.min()!!
        var primitives = (2..min).toList()
        var i = 0
        while (i < primitives.size) {
            val n = primitives[i]
            primitives = primitives.filter { it % n != 0 || it == n }
            i++
        }

        return primitives.any { p -> d.all { it % p == 0 } }
    }
}

fun main(args: Array<String>) {
    println(Solution914().hasGroupsSizeX(intArrayOf(1,1)))
}