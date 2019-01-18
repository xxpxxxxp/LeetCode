package com.ypwang.medium

class Solution851 {
    fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        val rst = IntArray(quiet.size){-1}
        val richers = List<MutableList<Int>>(quiet.size){ mutableListOf() }

        for (r in richer) {
            richers[r[1]].add(r[0])
        }

        fun fQuiet(i: Int): Int {
            if (rst[i] == -1) {
                rst[i] = i
                for (richer in richers[i]) {
                    val quieter = fQuiet(richer)
                    if (quiet[quieter] < quiet[rst[i]]) {
                        rst[i] = quieter
                    }
                }

            }

            return rst[i]
        }

        for (i in 0 until quiet.size) {
            fQuiet(i)
        }

        return rst
    }
}