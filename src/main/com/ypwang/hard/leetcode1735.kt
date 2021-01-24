package com.ypwang.hard

class Solution1735 {
    private val primes = mutableListOf<Int>()
    private val dp = Array(10015) { IntArray(15) }
    private val mod = 1000000007

    init {
        var list = (2..10000).toList()
        while (list.isNotEmpty()) {
            val p = list.first()
            primes.add(p)
            list = list.filter { it % p != 0 }
        }

        dp[0][0] = 1
        for (i in 1 until dp.size) {
            dp[i][0] = 1

            for (j in 1 until 15) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod
            }
        }
    }

    private fun factorize(num: Int): List<Int> {
        val rst = mutableListOf<Int>()
        var idx = 0
        var n = num
        while (n != 1) {
            val prime = primes[idx++]
            var count = 0
            while (n != 1 && n % prime == 0) {
                n /= prime
                count++
            }
            if (count > 0)
                rst.add(count)
        }

        return rst
    }

    fun waysToFillArray(queries: Array<IntArray>): IntArray =
        queries.map { (slot, num) ->
            factorize(num).map { dp[slot + it - 1][it] }.fold(1L) { acc, i -> acc * i % mod }.toInt()
        }.toIntArray()
}

fun main() {
    println(Solution1735().waysToFillArray(arrayOf(
        intArrayOf(2,6), intArrayOf(5,1), intArrayOf(73,660)
    )).toList())
}