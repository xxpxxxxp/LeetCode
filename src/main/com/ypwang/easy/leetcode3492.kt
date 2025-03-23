package com.ypwang.easy

class Solution3492 {
    fun maxContainers(n: Int, w: Int, maxWeight: Int): Int =
        minOf(n * n, maxWeight / w)
}
