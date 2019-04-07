package com.ypwang.medium

import java.util.*

class Solution478(radius: Double, x_center: Double, y_center: Double) {
    val x = x_center
    val y = y_center
    val r = radius
    val rand = Random()

    fun randPoint(): DoubleArray {
        val p = rand.nextDouble()
        val q = Math.sqrt(1.0 - p * p)
        val sign1 = if (rand.nextInt(2) % 2 == 0) 1 else -1
        val sign2 = if (rand.nextInt(2) % 2 == 0) 1 else -1
        return doubleArrayOf(x + r * p * sign1, y + r * q * sign2)
    }
}