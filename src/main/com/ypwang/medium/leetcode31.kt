package com.ypwang.medium

class Solution31 {
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.size < 2) {
            return
        }

        var j = nums.lastIndex
        while (nums[j - 1] >= nums[j]) {
            j--
            if (j == 0)
                break
        }

        if (j == 0) {
            nums.reverse()
            return
        }

        j--
        // find first element large than nums[j]
        var i = nums.lastIndex

        while (nums[i] <= nums[j]) {
            i--
        }

        // swap i & j
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t

        // reverse after j
        j++
        i = nums.lastIndex
        while (j < i) {
            val t1 = nums[i]
            nums[i] = nums[j]
            nums[j] = t1
            j++
            i--
        }
    }
}

fun main(args: Array<String>) {
    println(Solution31().nextPermutation(intArrayOf(1,3,2)))
}