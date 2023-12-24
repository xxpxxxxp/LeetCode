package com.ypwang.medium

class Solution2975 {
    fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
        var rst = 0
        val mod = 1000000007

        val hFen = hFences.copyOf(hFences.size + 2)
        val vFen = vFences.copyOf(vFences.size + 2)
        hFen[hFences.size] = 1
        hFen[hFences.size + 1] = m
        vFen[vFences.size] = 1
        vFen[vFences.size + 1] = n

        val hs = mutableSetOf<Int>()
        for (i in hFen.indices) {
            for (j in hFen.indices) {
                if (i != j) hs.add(Math.abs(hFen[i] - hFen[j]))
            }
        }
        for (i in vFen.indices) {
            for (j in vFen.indices) {
                if (Math.abs(vFen[i] - vFen[j]) in hs)
                    rst = maxOf(rst, Math.abs(vFen[i] - vFen[j]))
            }
        }
        return if (rst == 0) -1 else (rst.toLong() * rst % mod).toInt()
    }
}