package com.ypwang.medium

class Solution2929 {
    fun distributeCandies(n: Int, limit: Int): Long =
        (maxOf(0, (n - 2 * limit))..minOf(limit, n)).fold(0L) { acc, i ->
            acc + minOf(limit, n - i) - maxOf(0, n - i - limit) + 1
        }
}