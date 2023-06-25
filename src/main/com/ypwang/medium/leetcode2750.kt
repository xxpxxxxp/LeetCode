package com.ypwang.medium

class Solution2750 {
    fun numberOfGoodSubarraySplits(nums: IntArray): Int =
        nums.joinToString("")
            .trim('0')
            .let {
                if (it.isEmpty())
                    0
                else
                    it.split('1')
                        .fold(1L) { a, b ->
                            a * (b.length + 1) % 1000000007
                        }.toInt()
            }
}