package com.ypwang.hard

class Solution3971 {
    val MOD = 1000000007L

    fun maxTotalValue(value: IntArray, decay: IntArray, m: Int): Int {
        val positive = count(1, value, decay)

        if (positive <= m)
            return (getSum(1, value, decay) % MOD).toInt()

        var left = 1L
        var right = 0L

        for (v in value)
            right = maxOf(right, v.toLong())

        while (left < right) {
            val mid = (left + right + 1) / 2

            if (count(mid, value, decay) >= m)
                left = mid
            else
                right = mid - 1
        }

        val f = left
        val cnt = count(f + 1, value, decay)
        val sum = getSum(f + 1, value, decay)

        val rem = m - cnt
        val ans = sum + rem * f

        return (ans % MOD).toInt()
    }

    private fun count(x: Long, value: IntArray, decay: IntArray): Long {
        var total = 0L

        for (i in value.indices) {
            val v = value[i].toLong()
            val d = decay[i].toLong()

            if (v >= x)
                total += (v - x) / d + 1
        }

        return total
    }

    private fun getSum(x: Long, value: IntArray, decay: IntArray): Long {
        var total = 0L

        for (i in value.indices) {
            val v = value[i].toLong()
            val d = decay[i].toLong()

            if (v >= x) {
                val c = (v - x) / d + 1
                total += c * (2 * v - (c - 1) * d) / 2
            }
        }

        return total
    }
}
