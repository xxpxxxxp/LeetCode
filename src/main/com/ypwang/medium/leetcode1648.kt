package com.ypwang.medium

class Solution1648 {
    private val mod = 1000000007

    fun maxProfit(inventory: IntArray, orders: Int): Int {
        val iv = inventory.groupBy { it }.mapValues { it.value.size }.toList().sortedByDescending { it.first }.toTypedArray()

        var os = orders
        var rst = 0
        var idx = 0
        var count = 0

        while (true) {
            count += iv[idx].second
            val diff = (if (idx == iv.lastIndex) iv[idx].first else iv[idx].first - iv[idx+1].first).toLong()
            if (os > diff * count) {
                // take all
                rst = ((rst + count * (diff * iv[idx].first - (diff - 1) * diff / 2)) % mod).toInt()
                os -= diff.toInt() * count
                idx++
            } else {
                val take = (os / count).toLong()
                val c = os - take * count
                val d = count - c
                rst = ((rst + c * ((take + 1) * iv[idx].first - take * (take + 1) / 2)) % mod).toInt()
                rst = ((rst + d * (take * iv[idx].first - (take - 1) * take / 2)) % mod).toInt()

                return rst
            }
        }
    }
}

fun main() {
    println(Solution1648().maxProfit(intArrayOf(2,5), 4))
    println(Solution1648().maxProfit(intArrayOf(3,5), 6))
    println(Solution1648().maxProfit(intArrayOf(2,8,4,10,6), 20))
    println(Solution1648().maxProfit(intArrayOf(1000000000), 1000000000))
}