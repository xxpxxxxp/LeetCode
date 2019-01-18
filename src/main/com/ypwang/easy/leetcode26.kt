package com.ypwang.easy

class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var cur = nums[0]
        var start = 1
        var diff = 1
        while (diff < nums.size) {
            if (nums[diff] == cur) {
                diff++
            } else {
                nums[start] = nums[diff]
                start++
                cur = nums[diff]
            }
        }
        return start
    }
}

class Solution754 {
    fun helper(t: Int): Int {
        var l = 1
        var r = Math.max(3, Math.min(t / 2, 44722))
        while (l < r) {
            val middle = l + (r - l) / 2
            val m = middle * (middle + 1) / 2
            if (m == t) {
                return middle
            } else if (m < t) {
                l = middle+1
            } else {
                r = middle
            }
        }
        return r
    }

    fun reachNumber(target: Int): Int {
        val t = Math.abs(target)
        var x = helper(t)
        while (true) {
            val m = x * (x + 1) / 2
            if (m == t || (m - t) % 2 == 0) {
                return x
            }
            x++
        }
    }
}

fun main(args: Array<String>) {
    println(Solution754().reachNumber(3))
}