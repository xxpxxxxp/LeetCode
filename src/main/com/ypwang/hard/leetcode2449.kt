package com.ypwang.hard

class Solution2449 {
    fun makeSimilar(nums: IntArray, target: IntArray): Long {
        nums.sort()
        target.sort()

        val (odd, even) = nums.partition { it % 2 == 1 }
        val (todd, teven) = target.partition { it % 2 == 1 }

        return odd.zip(todd).filter { it.first > it.second }.map { (it.first - it.second) / 2L }.sum() +
                even.zip(teven).filter { it.first > it.second }.map { (it.first - it.second) / 2L }.sum()
    }
}