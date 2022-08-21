package com.ypwang.hard

class Solution2382 {
    fun maximumSegmentSum(nums: IntArray, removeQueries: IntArray): LongArray {
        val rst = LongArray(nums.size)
        val dsu = IntArray(nums.size) { it }
        val sum = LongArray(nums.size) { nums[it].toLong() }

        fun root(i: Int): Int {
            if (i != dsu[i])
                dsu[i] = root(dsu[i])

            return dsu[i]
        }

        fun union(i: Int, j: Int) {
            val r1 = root(i)
            val r2 = root(j)

            if (r1 != r2) {
                dsu[r1] = r2
                sum[r2] += sum[r1]
            }
        }

        val arr = IntArray(nums.size)
        var max = 0L

        for ((i, v) in removeQueries.withIndex().reversed()) {
            rst[i] = max
            arr[v] = nums[v]

            if (v+1 < nums.size && arr[v+1] > 0)
                union(v, v+1)
            if (v-1 >= 0 && arr[v-1] > 0)
                union(v, v-1)

            max = maxOf(max, sum[root(v)])
        }

        return rst
    }
}

fun main() {
    println(Solution2382().maximumSegmentSum(intArrayOf(1,2,5,6,1), intArrayOf(0,3,2,4,1)).toList())
}