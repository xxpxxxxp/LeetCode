package com.ypwang.hard

class Solution1411 {
    // 0: ABA
    // 1: ABC
    private val map = mapOf(
            0 to listOf(0 to 3L, 1 to 2L),
            1 to listOf(0 to 2L, 1 to 2L)
    )
    private val mod = 1000000007
    private fun Collection<Int>.modSum(): Int = this.reduce { acc, i -> (acc + i) % mod }

    fun numOfWays(n: Int): Int =
        (1 until n).fold(mapOf(0 to 6, 1 to 6)){ cur, _ ->
            cur.flatMap {
                map[it.key]!!.map { pair -> pair.first to (pair.second * it.value % mod).toInt() }
            }.groupBy { it.first }.mapValues { it.value.map { pair -> pair.second }.modSum() }.toMap()
        }.values.modSum()
}

fun main() {
    println(Solution1411().numOfWays(1))
    println(Solution1411().numOfWays(2))
    println(Solution1411().numOfWays(3))
    println(Solution1411().numOfWays(7))
    println(Solution1411().numOfWays(5000))
}