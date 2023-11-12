package com.ypwang.medium

class Solution2933 {
    fun findHighAccessEmployees(access_times: List<List<String>>): List<String> =
        access_times
            .groupBy { it.first() }
            .filter {
                val times = it.value
                    .map { s -> s[1].substring(0, 2).toInt() * 60 + s[1].substring(2, 4).toInt() }
                    .sorted()
                    .toIntArray()

                (0 until times.size - 2).any { i -> times[i+2] - times[i] < 60 }
            }
            .map { it.key }
}