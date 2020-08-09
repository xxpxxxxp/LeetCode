package com.ypwang.medium

class Solution1519 {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val map = edges.flatMap { listOf(it[0] to it[1], it[1] to it[0]) }
                .groupBy { it.first }
                .mapValues { it.value.map { kv -> kv.second } }
                .toMap()

        val rst = IntArray(n)
        fun postOrder(idx: Int, from: Int): IntArray {
            rst[idx] = 1

            val descending = map.getOrDefault(idx, listOf())
                    .filter { it != from }
                    .map { postOrder(it, idx) }
            if (descending.isEmpty()) return IntArray(26).apply {
                this[labels[idx] - 'a']++
            }

            val count = descending.reduce { i1, i2 ->
                for (i in i1.indices)
                    i1[i] += i2[i]

                i1
            }

            rst[idx] += count[labels[idx] - 'a']
            count[labels[idx] - 'a']++
            return count
        }

        postOrder(0, -1)
        return rst
    }
}

fun main() {
    println(Solution1519().countSubTrees(7, arrayOf(
            intArrayOf(0,1),intArrayOf(0,2),intArrayOf(1,4),intArrayOf(1,5),intArrayOf(2,3),intArrayOf(2,6)), "abaedcd").toList())
}