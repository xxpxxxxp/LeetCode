package com.ypwang.easy

class Solution1460 {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean =
            target.groupBy { it }.mapValues { it.value.size } == arr.groupBy { it }.mapValues { it.value.size }
}