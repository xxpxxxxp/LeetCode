package com.ypwang.medium

class Solution3960 {
    fun getLength(nums: IntArray): Int {
        val n = nums.size
        var ans = 1
        for (i in 0 until n) {
            val mp = mutableMapOf<Int, Int>()
            val fq = IntArray(n + 1)
            var mx = 0
            var s = 0
            for (j in i until n) {
                val old = mp.getOrDefault(nums[j], 0)
                if (old > 0)
                    fq[old]--

                mp[nums[j]] = old + 1
                fq[old + 1]++ // add new frequency

                if (old + 1 > mx) {
                    mx = old + 1
                    s = 1 // new maximum frequency found
                } else if (old + 1 == mx) {
                    s++ // another value reaches maximum frequency
                }

                val distinct = mp.size
                if (distinct == 1) {
                    ans = maxOf(ans, j - i + 1)
                } else if (mx % 2 == 0 && s < distinct && fq[mx / 2] == distinct - s) {
                    ans = maxOf(ans, j - i + 1)
                }
            }
        }
        return ans
    }
}
