package com.ypwang.hard

class Solution354 {
    data class Pair(val count: Int, var `val`: Int)

    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        if (envelopes.isEmpty()) return 0

        val heights = envelopes.sortedWith(Comparator { o1, o2 -> if (o1[0] != o2[0]) o1[0] - o2[0] else o2[1] - o1[1] }).map { it[1] }
        val sequences = ArrayList<Pair>()
        sequences.add(Pair(1, Int.MAX_VALUE))

        for (h in heights) {
            val idx = sequences.binarySearch { it.`val` - h }
            if (idx >= 0) continue
            val pidx = -idx - 1
            if (pidx == sequences.size) sequences.add(Pair(sequences.last().count+1, h))
            else sequences[pidx].`val` = minOf(sequences[pidx].`val`, h)
        }

        return sequences.last().count
    }
}

fun main() {
    println(Solution354().maxEnvelopes(arrayOf(intArrayOf(5,4), intArrayOf(6,4), intArrayOf(6,7), intArrayOf(2,3))))
}