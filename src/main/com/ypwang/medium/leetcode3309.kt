package com.ypwang.medium

class Solution3309 {
    fun maxGoodNumber(nums: IntArray): Int =
        nums.map { it.toString(2) }
            .sortedWith(object: Comparator<String>{
                override fun compare(o1: String, o2: String): Int =
                    (o2 + o1).compareTo(o1 + o2)
            })
            .joinToString("")
            .toInt(2)
}
