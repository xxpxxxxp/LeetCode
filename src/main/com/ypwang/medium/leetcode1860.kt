package com.ypwang.medium

class Solution1860 {
    private fun stage1(diff: Long): Long {
        var left = 0L
        var right = 100000L

        while (left < right) {
            val mid = (left + right + 1) / 2

            if (mid * (mid + 1) / 2 > diff)
                right = mid - 1
            else
                left = mid
        }

        return left
    }

    private fun stage2(start: Long, total: Long): Long {
        var left = 0L
        var right = (100000L - start) / 2L

        while (left < right) {
            val mid = (left + right + 1) / 2

            if (mid * start + mid * (mid-1) > total)
                right = mid - 1
            else
                left = mid
        }

        return left
    }

    fun memLeak(memory1: Int, memory2: Int): IntArray {
        val nums = arrayOf(longArrayOf(memory1.toLong(), 1L), longArrayOf(memory2.toLong(), 2L))
        nums.sortByDescending { it[0] }

        val n = stage1(Math.abs(memory1 - memory2).toLong())
        nums[0][0] -= n * (n+1) / 2
        nums.sortWith(compareByDescending<LongArray> { it[0] }.thenBy { it[1] })

        val n2 = stage2(n+2, nums[1][0])
        nums[0][0] -= n2 * (n+1) + n2 * (n2-1)
        nums[1][0] -= n2 * (n+2) + n2 * (n2-1)

        var tn = n + 2 * n2
        if (nums[0][0] >= tn+1) {
            nums[0][0] -= ++tn
        }

        val rst = intArrayOf(tn.toInt()+1, 0, 0)
        for ((v, i) in nums)
            rst[i.toInt()] = v.toInt()

        return rst
    }
}

fun main() {
    println(Solution1860().memLeak(8, 11).toList())
    println(Solution1860().memLeak(1904841917, 885391039).toList())
    println(Solution1860().memLeak(62704240, 732423786).toList())
    println(Solution1860().memLeak(2, 2).toList())
}