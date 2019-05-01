package com.ypwang.medium

class Solution777 {
    fun canTransform(start: String, end: String): Boolean {
        val s = start.withIndex().filter { it.value != 'X' }.toTypedArray()
        val e = end.withIndex().filter { it.value != 'X' }.toTypedArray()

        if (s.map { it.value } != e.map { it.value }) return false

        var barrier = 0
        for (i in s.zip(e)) {
            when (i.first.value) {
                'L' -> {
                    // L can only move left
                    if (i.first.index < i.second.index) return false
                    if (i.second.index < barrier) return false
                    barrier = i.second.index
                }
                'R' -> {
                    // R can only move right
                    if (i.first.index > i.second.index) return false
                    if (i.second.index < barrier) return false
                    barrier = i.second.index
                }
            }
        }

        return true
    }
}

fun main() {
    println(Solution777().canTransform("XXRXLXRXXX", "XXRLXXXXXR"))
}