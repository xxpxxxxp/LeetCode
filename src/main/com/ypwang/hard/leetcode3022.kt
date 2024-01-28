package com.ypwang.hard

class Solution3022 {
    fun minOrAfterOperations(nums: IntArray, k: Int): Int {
        var rst = 0
        for (j in 30 downTo 0) {
            var cnt = 0
            var cur = (1 shl 30) - 1
            val target = rst or ((1 shl j) - 1)
            for (n in nums) {
                cur = cur and n
                if (cur or target == target) {
                    cnt++
                    cur = (1 shl 30) - 1
                }
            }

            if (nums.size - cnt > k)
                rst = rst or (1 shl j)
        }

        return rst
    }
}
