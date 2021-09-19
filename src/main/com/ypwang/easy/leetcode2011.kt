package com.ypwang.easy

class Solution2011 {
    fun finalValueAfterOperations(operations: Array<String>): Int =
        operations.groupBy { it }.mapValues { it.value.size }.map { (t, c) ->
            when (t) {
                "++X", "X++" -> c
                else -> -c
            }
        }.sum()
}