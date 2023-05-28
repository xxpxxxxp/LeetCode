package com.ypwang.medium

class Solution2708 {
    fun maxStrength(nums: IntArray): Long {
        val pos = mutableListOf<Int>()
        val neg = mutableListOf<Int>()
        var ans = 1L
        var flag = false
        var zero = false
        for (num in nums) {
            if (num > 0)
                pos.add(num)
            else if (num < 0)
                neg.add(Math.abs(num))
            else
                zero = true
        }
        for (n in pos) {
            flag = true
            ans *= n.toLong()
        }
        if (neg.size % 2 != 0 && neg.size > 1) {
            neg.sortDescending()
            neg.removeAt(neg.size - 1) // remove the smallest guy
        }
        if (neg.size > 1) {
            for (n in neg) {
                flag = true
                ans *= n.toLong()
            }
        }
        if (neg.size == 1 && zero && pos.size == 0)
            return 0
        if (neg.size == 1 && pos.size == 0)
            return (-neg[0]).toLong()
        return if (flag) maxOf(ans, 0) else 0
    }
}