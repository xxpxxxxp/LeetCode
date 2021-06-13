package com.ypwang.medium

class Solution1899 {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean =
        (0..2).all { idx ->
            triplets.any { arr -> arr[idx] == target[idx] && (0..2).all { i ->
                arr[i] <= target[i]
            } }
        }
}