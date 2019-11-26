package com.ypwang.medium

class Solution1239 {
    fun maxLength(arr: List<String>): Int {
        val t = mutableListOf<Int>()
        label@ for (s in arr) {
            var i = 0
            for (c in s) {
                val d = c - 'a'
                if (i and (1 shl d) > 0) continue@label
                i = i or (1 shl d)
            }

            t.add(i)
        }

        return t.fold(setOf(0)){ cur, i ->
            cur + (cur.filter { i and it == 0 }.map { i or it })
        }.map { Integer.bitCount(it) }.max()!!
    }
}

fun main() {
    println(Solution1239().maxLength(listOf("un","iq","ue")))
}