package com.ypwang.medium

import java.util.Random

class Solution398(val nums: IntArray) {
    fun pick(target: Int): Int {
        var index = nums.indexOf(target)
        var count = 1

        val rand = Random()
        for (i in index + 1 until nums.size) {
            if (nums[i] == target) {
                count++
                if (rand.nextInt(count) == 0) {
                    index = i
                }
            }
        }

        return index
    }
}