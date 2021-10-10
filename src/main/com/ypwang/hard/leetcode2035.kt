package com.ypwang.hard

class Solution2035 {
    fun minimumDifference(nums: IntArray): Int {
        val sum = nums.sum()
        val N = nums.size / 2

        val left = Array(N+1) { mutableListOf<Int>() }
        val right = Array(N+1) { mutableListOf<Int>() }

        left[0] = mutableListOf(0)
        right[0] = mutableListOf(0)

        for (i in 0 until N) {
            val l = nums[i]
            val r = nums[i+N]
            for (j in i+1 downTo 1) {
                left[j].addAll(left[j-1].map { it + l })
                right[j].addAll(right[j-1].map { it + r })
            }
        }

        right.forEach { it.sort() }

        var rst = Int.MAX_VALUE
        for(size in 0 until N) {
            for(a in left[size]) {
                val r = right[N - size]
                val b = (sum - 2 * a) / 2

                val idx = r.binarySearch(b)
                if (idx >= 0)
                    rst = minOf(rst, Math.abs(sum - 2 * (a + b)))
                else {
                    val i = -idx-1
                    if (i < r.size)
                        rst = minOf(rst, Math.abs(sum - 2 * (a + r[i])))
                    if (i > 0)
                        rst = minOf(rst, Math.abs(sum - 2 * (a + r[i-1])))
                }

                if (rst == 0)
                    return 0
            }
        }
        return rst
    }
}

fun main() {
    println(Solution2035().minimumDifference(intArrayOf(-36,36)))
}