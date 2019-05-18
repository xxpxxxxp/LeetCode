package com.ypwang.hard

class Solution996 {
    fun numSquarefulPerms(A: IntArray): Int {
        val relation = Array(A.size){ mutableListOf<Int>() }

        for (i in 0 until A.size-1) {
            val ni = A[i]
            for (j in i+1 until A.size) {
                val num = ni + A[j]
                val sqrt = Math.sqrt(num.toDouble()).toInt()
                if (sqrt * sqrt == num) {
                    relation[i].add(j)
                    relation[j].add(i)
                }
            }
        }

        var sum = 0
        val state = (1 shl A.size) - 1

        val cache = mutableMapOf<Int, Int>()
        fun helper(cur: Int, s: Int): Int {
            if (s == 0) return 1
            val idx = (s shl 4) + cur
            if (idx !in cache)
                cache[idx] = relation[cur].filter { s and (1 shl it) != 0 }.sumBy { helper(it, s xor (1 shl it)) }

            return cache[idx]!!
        }

        if (relation.any { it.isEmpty()} ) return 0
        val idxs = relation.withIndex().filter { it.value.size == 1 }.map { it.index }

        // if there's sb has only 1 connection, it must be at the beginning (or end, mirrored)
        if (idxs.isNotEmpty()) {
            if (idxs.size > 2) return 0
            sum = 2 * helper(idxs.first(), state xor (1 shl idxs.first()))         // mirror
        } else {
            for (i in 0 until relation.size) {
                sum += helper(i, state xor (1 shl i))
            }
        }

        return sum / A.groupBy { it }.map {
            var i = 1
            var c = it.value.size
            while (c > 0) {
                i *= c
                c--
            }
            i
        }.reduce { a, b -> a * b }
    }
}

fun main() {
    println(Solution996().numSquarefulPerms(intArrayOf(2,2,2,2,2,2,2,2,2,2,2,2)))
}