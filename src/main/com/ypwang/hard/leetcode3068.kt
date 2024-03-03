package com.ypwang.hard

class Solution3068 {
    fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
        var sum = 0L
        var cnt = 0
        var sacrifice = Int.MAX_VALUE

        for (n in nums) {
            val t = n xor k
            sum += maxOf(t, n)
            if (t > n)
                cnt++
            sacrifice = minOf(sacrifice, Math.abs(n - t))
        }

        return sum - if (cnt % 2 == 0) 0 else sacrifice
    }
}
