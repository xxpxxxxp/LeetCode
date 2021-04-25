package com.ypwang.medium

class Solution1823 {
    fun findTheWinner(n: Int, k: Int): Int =
        (1..n).fold(0) { acc, i -> (acc + k) % i } + 1
}
