package com.ypwang.medium

class Solution4025 {
    fun minPenalty(period: Int, lights: IntArray, arrivalTime: IntArray): Int {
        val maxi = lights.max()
        var res = 0

        for (t in arrivalTime) {
            val r = t % period
            if (r >= maxi)
                res = maxOf(res, period - r)
        }

        return res
    }
}
