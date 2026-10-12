package com.ypwang.medium

class Solution4076 {
    fun resilientSubarray(nums: IntArray, k: Int): Int {
        val n = nums.size
        var ans = 1

        var i = 0
        while (i < n) {
            val rem = nums[i] % k
            var j = i

            while (j < n && nums[j] % k == rem)
                j++

            val len = j - i

            if (rem == 0)
                ans = maxOf(ans, len)
            else {
                val p = k / gcd(rem, k)
                val vL = 1 + ((len - 1) / p) * p
                ans = maxOf(ans, vL)
            }

            i = j - 1
            i++
        }

        return ans
    }

    fun gcd(a: Int, b: Int): Int =
        if (a == 0) b else gcd(b % a, a)
}
