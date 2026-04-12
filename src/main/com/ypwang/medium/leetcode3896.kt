package com.ypwang.medium

class Solution3896 {
    fun sieve(n: Int): BooleanArray {
        val bans = BooleanArray(n + 1) { true }
        bans[0] = false
        bans[1] = false
        var i = 2
        while (i * i <= n) {
            var j = i * i
            while (j <= n) {
                bans[j] = false
                j += i
            }
            i++
        }
        return bans
    }

    fun minOperations(nums: IntArray): Int {
        val bans = sieve(100001)
        val nextPrime = IntArray(100002)
        var ptr = 100003
        for (j in 100001 downTo 0) {
            if (bans[j])
                ptr = j

            nextPrime[j] = ptr - j
        }
        var ans = 0
        for (i in nums.indices) {
            if (i % 2 == 0) {
                ans += nextPrime[nums[i]]
            } else {
                if (bans[nums[i]]) {
                    var j = nums[i]
                    while (bans[j])
                        j++

                    ans += (j - nums[i])
                }
            }
        }
        return ans
    }
}
