package com.ypwang.medium

import java.util.*

class Solution528(w: IntArray) {
    val weight = Array(w.size){0}
    val rand = Random()

    init {
        for ((i, v) in  w.withIndex()) {
            if (i == 0) {
                weight[0] = v
            } else {
                weight[i] = weight[i-1] + v
            }
        }
    }

    fun pickIndex(): Int {
        val i = weight.binarySearch(rand.nextInt(weight.last()))
        return if (i >= 0) i + 1 else -i - 1
    }
}