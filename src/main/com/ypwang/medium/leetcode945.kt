package com.ypwang.medium

class Solution945 {
    private class pair(var key: Int, var value: Int)

    fun minIncrementForUnique(A: IntArray): Int {
        val t = A.groupBy { it }.mapValues { it.value.size }.map { pair(it.key, it.value) }.sortedByDescending { it.key }.toMutableList()
        var sum = 0
        while (t.isNotEmpty()) {
            val last = t.last()
            t.removeAt(t.lastIndex)

            if (last.value > 1) {
                if (t.isEmpty() || t.last().key - last.key > last.value) {
                    sum += last.value * (last.value - 1) / 2
                } else {
                    val l = t.last()
                    t.removeAt(t.lastIndex)
                    sum += (last.value + last.key - l.key) * (l.key - last.key) + (l.key - last.key) * (l.key - last.key - 1) / 2
                    t.add(pair(l.key, last.value + last.key - l.key + l.value))
                }
            }
        }

        return sum
    }
}

fun main() {
    println(Solution945().minIncrementForUnique(intArrayOf(1,2,2)))
}