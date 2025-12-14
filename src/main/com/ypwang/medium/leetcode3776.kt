package com.ypwang.medium

class Solution3776 {
    fun minMoves(balance: IntArray): Long {
        val n = balance.size
        var j = -1
        var total = 0L

        for (i in 0 until n) {
            if (balance[i] < 0)
                j = i
            total += balance[i].toLong()
        }
        if (j == -1)
            return 0
        if (total < 0)
            return -1

        var res = 0L
        var d = 1
        while (balance[j] < 0) {
            val storage = (balance[(j + d) % n] + balance[(j - d % n + n) % n]).toLong()
            res += minOf(-balance[j].toLong(), storage) * d
            balance[j] += storage.toInt()
            ++d
        }
        return res
    }
}
