package com.ypwang.medium

class Solution898 {
    fun subarrayBitwiseORs(A: IntArray): Int {
        val all = mutableSetOf(A[0])
        var cur = setOf(A[0])

        for (i in 1 until A.size) {
            cur = (cur.map { it or A[i] } + A[i]).toSet()
            all.addAll(cur)
        }

        return all.size
    }
}

fun main() {
    println(Solution898().subarrayBitwiseORs(intArrayOf(1,1,2)))
}