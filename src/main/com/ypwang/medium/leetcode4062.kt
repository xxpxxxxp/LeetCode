package com.ypwang.medium

class Solution4062 {
    fun canTransform(source: IntArray, target: IntArray): Boolean =
        source.fold(1L) { a, b -> a + b } == target.fold(1L) { a, b -> a + b }
}
