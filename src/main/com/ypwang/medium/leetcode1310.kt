package com.ypwang.medium

class Solution1310 {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        for (i in 1 until arr.size) {
            arr[i] = arr[i-1] xor arr[i]
        }

        val rst = IntArray(queries.size)
        for ((i, kv) in queries.withIndex()) {
            rst[i] = arr[kv[1]]
            if (kv[0] > 0) rst[i] = rst[i] xor arr[kv[0]-1]
        }

        return rst
    }
}

fun main() {
    println(Solution1310().xorQueries(intArrayOf(1,3,4,8), arrayOf(
            intArrayOf(0,1), intArrayOf(1,2), intArrayOf(0,3), intArrayOf(3,3)
    )).toList())
}