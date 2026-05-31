package com.ypwang.medium

class Solution3947 {
    fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val mxF = items.maxOf { it[0] }

        val freq = IntArray(mxF + 1)
        val cnt = IntArray(mxF + 1)

        for (item in items)
            freq[item[0]]++

        for (i in 1..mxF) {
            var j = i
            while (j <= mxF) {
                cnt[i] += freq[j]
                j += i
            }
        }

        val store = items.map { it[1].toLong() to cnt[it[0]].toLong() - 1 }.sortedBy { it.first }
        val m = store.first().first

        var remaining = budget.toLong()
        var total = 0L
        val lim = 2L * m

        for ((a, b) in store) {
            if (a >= lim)
                break

            if (b <= 0)
                continue

            val take = minOf(b, remaining / a)

            total += 2L * take
            remaining -= take * a

            if (take < b)
                break
        }

        total += remaining / m
        return total.toInt()
    }
}
