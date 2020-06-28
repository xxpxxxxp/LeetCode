package com.ypwang.medium

class Solution1498 {
    fun numSubseq(nums: IntArray, target: Int): Int {
        val mod = 1000000007
        nums.sort()

        val pre = IntArray(nums.size)
        pre[0] = 1
        for (i in 1 until pre.size) {
            pre[i] = pre[i-1] * 2 % mod
        }

        var rst = 0
        var j = nums.lastIndex
        for (i in nums.indices) {
            while (j >= i && nums[i] + nums[j] > target) {
                j--
            }

            val c = j - i
            if (c < 0) break
            rst = (rst + pre[c]) % mod
        }

        return rst
    }
}

fun main() {
    println(Solution1498().numSubseq(intArrayOf(27,21,14,2,15,1,19,8,12,24,21,8,12,10,11,30,15,18,28,14,26,9,2,24,23,11,7,12,9,17,30,9,28,2,14,22,19,19,27,6,15,12,29,2,30,11,20,30,21,20,2,22,6,14,13,19,21,10,18,30,2,20,28,22), 31))
    println(Solution1498().numSubseq(intArrayOf(1), 1))
    println(Solution1498().numSubseq(intArrayOf(3,5,6,7), 9))
    println(Solution1498().numSubseq(intArrayOf(3,3,6,8), 10))
    println(Solution1498().numSubseq(intArrayOf(2,3,3,4,6,7), 12))
    println(Solution1498().numSubseq(intArrayOf(5,2,4,1,7,6,8), 16))
}