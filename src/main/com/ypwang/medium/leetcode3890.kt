package com.ypwang.medium

import kotlin.math.cbrt

class Solution3890 {
    fun findGoodIntegers(n: Int): List<Int> {
        val map = mutableMapOf<Int, Int>()
        val limit = cbrt(n.toDouble()).toInt()
        for (a in 1..limit) {
            val a3 = a * a * a
            for (b in a..limit) {
                val sum = a3 + b * b * b
                if (sum > n)
                    break
                map[sum] = map.getOrDefault(sum, 0) + 1
            }
        }

        return map.filter { it.value > 1 }.keys.sorted()
    }
}
