package com.ypwang.medium

class Solution4032 {
    fun longestSubarray(nums: IntArray, k: Int): Int {
        val n = nums.size
        val max = nums.max()

        val smallFact = IntArray(max + 1) { it }

        var i = 2
        while (i * i <= max) {
            if (smallFact[i] == i) {
                var j = i * i
                while (j <= max) {
                    if (smallFact[j] == j)
                        smallFact[j] = i
                    j += i
                }
            }
            i++
        }

        val fact = Array(n) { mutableListOf<Int>() }
        for (i in 0 until n) {
            var v = nums[i]
            while (v > 1) {
                val p = smallFact[v]
                fact[i].add(p)
                while (v % p == 0)
                    v /= p
            }
        }

        val freq = IntArray(max + 1)
        var left = 0
        var right = 0
        var res = 0
        var count = 0
        while (right < n) {
            for (p in fact[right]) {
                if (freq[p] == 0)
                    count++
                freq[p]++
            }
            while (count > k) {
                for (p in fact[left]) {
                    if (freq[p!!] == 1)
                        count--
                    freq[p]--
                }
                left++
            }
            right++
            res = maxOf(res, right - left)
        }
        return res
    }
}
