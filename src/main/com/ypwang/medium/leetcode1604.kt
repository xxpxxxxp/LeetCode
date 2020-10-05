package com.ypwang.medium

class Solution1604 {
    fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> =
        keyTime
                .map {
                    val (h, m) = it.split(":")
                    h.toInt() * 60 + m.toInt()
                }
                .zip(keyName)
                .sortedBy { it.first }
                .groupBy { it.second }
                .mapValues { it.value.map { kv -> kv.first } }
                .filter {
                    val t = it.value.toTypedArray()
                    for (i in 0 until t.size - 2) {
                        if (t[i+2] - t[i] <= 60)
                            return@filter true
                    }
                    false
                }
                .map { it.key }
                .sorted()
}