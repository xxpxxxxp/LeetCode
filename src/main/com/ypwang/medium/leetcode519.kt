package com.ypwang.medium

import java.util.*

class Solution519(val n_rows: Int, val n_cols: Int) {
    var total = n_rows * n_cols
    val sampled = mutableMapOf<Int, Int>()
    val rand = Random()

    fun flip(): IntArray {
        val r = rand.nextInt(total--)
        val actual = sampled.getOrDefault(r, r)
        sampled[r] = sampled.getOrDefault(total, total)

        return intArrayOf(actual / n_cols, actual % n_cols)
    }

    fun reset() {
        total = n_rows * n_cols
        sampled.clear()
    }
}
