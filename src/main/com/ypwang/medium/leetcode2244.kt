package com.ypwang.medium

class Solution2244 {
    fun minimumRounds(tasks: IntArray): Int =
        tasks.groupBy { it }
            .map { it.value.size }
            .map {
                val c = it / 3
                when (it % 3) {
                    0 -> c
                    1 ->
                        if (c == 0)
                            return -1
                        else c + 1
                    else ->
                        c + 1
                }
            }
            .sum()
}