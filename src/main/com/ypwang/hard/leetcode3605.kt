package com.ypwang.hard

class Solution3605 {
    fun minStable(nums: IntArray, maxC: Int): Int {
        val n = nums.size
        var l = 0
        var r = n + 1
        while (l + 1 < r) {
            val mid = (l + r) / 2
            if (countBroken(nums, n, mid) <= maxC)
                r = mid
            else
                l = mid
        }

        return l
    }

    private fun countBroken(nums: IntArray, n: Int, len: Int): Int {
        var req = 0
        var i = 0
        while (i + len - 1 < n) {
            var g = nums[i]
            var j = i + 1
            while (j < i + len && g > 1) {
                g = gcd(g, nums[j])
                j++
            }
            if (g > 1) {
                req++
                i += len
            } else {
                i++
            }
        }

        return req
    }

    private fun gcd(a: Int, b: Int): Int =
        if (a == 0) b else gcd(b % a, a)
}

fun main() {
    println(Solution3605().minStable(intArrayOf(3,5,10), 1))
}