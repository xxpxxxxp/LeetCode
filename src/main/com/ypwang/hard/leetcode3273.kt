package com.ypwang.hard

class Solution3273 {
    fun minDamage(power: Int, damage: IntArray, health: IntArray): Long {
        for (i in health.indices)
            health[i] = (health[i] + power - 1) / power

        return health.zip(damage).sortedByDescending { (h, d) -> d.toDouble() / h }
            .fold(0L to 0) { (rst, time), (h, d) ->
                val curTime = time + h
                rst + curTime * d to curTime
            }.first
    }
}
