package com.ypwang.hard

class Solution1681 {
    private fun masks(nums: IntArray, count: Int): IntArray {
        val rst = IntArray(1 shl nums.size){-1}
        var set: Int
        var min: Int
        var max: Int
        outer@ for (i in rst.indices) {
            set = 0
            min = Int.MAX_VALUE
            max = Int.MIN_VALUE
            if (Integer.bitCount(i) == count) {
                for ((j, v) in nums.withIndex()) {
                    if (i and (1 shl j) > 0) {
                        if (set and (1 shl v) > 0)
                            continue@outer

                        set = set or (1 shl v)
                        min = minOf(min, v)
                        max = maxOf(max, v)
                    }
                }

                rst[i] = max - min
            }
        }

        return rst
    }

    fun minimumIncompatibility(nums: IntArray, k: Int): Int {
        val m = nums.size / k
        val mask = masks(nums, m)

        val dp = IntArray(1 shl nums.size){Int.MAX_VALUE}
        dp[0] = 0

        for (i in 1 until dp.size) {
            if (Integer.bitCount(i) % m == 0) {
                var j = i
                while (j > 0) {
                    if (mask[j] != -1 && dp[i-j] != Int.MAX_VALUE)
                        dp[i] = minOf(dp[i], dp[i-j] + mask[j])

                    j = (j - 1) and i
                }
            }
        }

        return dp.last().let { if (it == Int.MAX_VALUE) -1 else it }
    }
}

fun main() {
    println(Solution1681().minimumIncompatibility(intArrayOf(1,2,1,4), 2))
    println(Solution1681().minimumIncompatibility(intArrayOf(6,3,8,1,3,1,2,2), 4))
    println(Solution1681().minimumIncompatibility(intArrayOf(5,3,3,6,3,3), 3))
}