package com.ypwang.hard

class Solution2136 {
    fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int =
        plantTime.zip(growTime).sortedBy { it.second }.fold(0) { cur, (p, g) -> maxOf(cur, g) + p }
}