package com.ypwang.hard

class Solution1835 {
    fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
        val l1 = IntArray(32)
        for (i in arr1) {
            for (j in 0 until 32) {
                if (i and (1 shl j) > 0)
                    l1[j]++
            }
        }

        val l2 = IntArray(32)
        for (i in arr2) {
            for (j in 0 until 32) {
                if (i and (1 shl j) > 0)
                    l2[j]++
            }
        }

        var rst = 0
        for (j in 0 until 32) {
            if (l1[j] * l2[j] % 2 == 1)
                rst = rst or (1 shl j)
        }

        return rst
    }
}

fun main() {
    println(Solution1835().getXORSum(intArrayOf(1,2,3), intArrayOf(6,5)))
    println(Solution1835().getXORSum(intArrayOf(12), intArrayOf(4)))
}