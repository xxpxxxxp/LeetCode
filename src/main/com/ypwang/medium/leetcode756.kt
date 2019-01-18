package com.ypwang.medium

class Solution756 {
    fun charToInt(c: Char): Int {
        return c - 'A' + 1
    }

    fun hash(a: Int, b: Int): Int {
        return a * 29 + b
    }

    lateinit var allows: Map<Int, List<Int>>
    lateinit var fails: MutableSet<IntArray>

    fun recur(last: IntArray): Boolean {
        if (last.size == 1) {
            return true
        }

        if (last in fails) {
            return false
        }

        if (helper(last.toList(), 0, mutableListOf())) {
            return true
        }
        fails.add(last)
        return false
    }

    fun helper(combination: List<Int>, index: Int, current: MutableList<Int>): Boolean {
        if (index == combination.size - 1) {
            return recur(current.toIntArray())
        }

        for (p in allows.getOrDefault(hash(combination[index], combination[index+1]), listOf())) {
            current.add(p)
            if (helper(combination, index+1, current)) {
                return true
            }
            current.removeAt(current.lastIndex)
        }
        return false
    }

    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        allows = allowed.map { Pair(hash(charToInt(it[0]), charToInt(it[1])), charToInt(it[2])) }
                .groupBy { it.first }.mapValues { it.value.map { i -> i.second } }
        fails = mutableSetOf()

        return recur(bottom.map { charToInt(it) }.toIntArray())
    }
}

fun main(args: Array<String>) {
    println(Solution756().pyramidTransition("XYZ", listOf("XYD", "YZE", "DEA", "FFF")))
}