package com.ypwang.medium

class Solution3814 {
    fun maxCapacity(costs: IntArray, capacity: IntArray, budget: Int): Int {
        val n = costs.size
        val a = Array(n) { costs[it] to capacity[it] }
        a.sortBy { it.first }

        val p = IntArray(n)
        var mx = 0
        for (i in 0 until n) {
            mx = maxOf(mx, a[i].second)
            p[i] = mx
        }

        var ans = 0
        var j = n - 1
        for (i in 0 until n) {
            val (c, v) = a[i]
            if (c < budget)
                ans = maxOf(ans, v)
            while (j >= 0 && a[j].first >= budget - c)
                j--
            val k = minOf(i - 1, j)
            if (k >= 0)
                ans = maxOf(ans, v + p[k])
        }
        return ans
    }
}
