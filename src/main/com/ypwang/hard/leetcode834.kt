package com.ypwang.hard

class Solution834 {
    fun sumOfDistancesInTree(N: Int, edges: Array<IntArray>): IntArray {
        if (N == 1) return intArrayOf(0)

        val map = edges.flatMap { listOf(it[0] to it[1], it[1] to it[0]) }
                .groupBy { it.first }.mapValues { it.value.map { kv -> kv.second } }

        val cnt = IntArray(N)
        val rst = IntArray(N)

        // return #sub node, sum(path)
        fun counts(from: Int, idx: Int): Pair<Int, Int> {
            val subs = map[idx]!!.filter { it != from }!!.map { counts(idx, it) }

            if (subs.isEmpty()) {
                cnt[idx] = 1
                return 1 to 0
            }
            val numSubs = subs.sumBy { it.first }
            cnt[idx] = numSubs + 1
            return cnt[idx] to numSubs + subs.sumBy { it.second }
        }

        fun generate(from: Int, idx: Int, path: Int) {
            rst[idx] = path
            for (i in map[idx]!!.filter { it != from }) {
                generate(idx, i, path + cnt[0] - 2 * cnt[i])
            }
        }

        generate(-1, 0, counts(-1, 0).second)
        return rst
    }
}

fun main() {
    println(Solution834().sumOfDistancesInTree(6, arrayOf(
            intArrayOf(0,1), intArrayOf(0,2), intArrayOf(2,3), intArrayOf(2,4), intArrayOf(2,5)
    )).toList())
}