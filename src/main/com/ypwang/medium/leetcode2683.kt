package com.ypwang.medium

class Solution2683 {
    fun doesValidArrayExist(derived: IntArray): Boolean =
        derived.sum() % 2 == 0
}