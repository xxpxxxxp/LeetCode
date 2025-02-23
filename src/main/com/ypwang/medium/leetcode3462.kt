package com.ypwang.medium

class Solution3462 {
    fun maxSum(grid: Array<IntArray>, limits: IntArray, k: Int): Long =
        grid.zip(limits.toList())
            .flatMap { (arr, l) ->
                arr.sortedDescending().take(l)
            }.sortedDescending()
            .take(k)
            .fold(0L) { a, b -> a + b }
}
