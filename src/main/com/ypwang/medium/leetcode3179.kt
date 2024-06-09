package com.ypwang.medium

class Solution3179 {
    fun valueAfterKSeconds(n: Int, k: Int): Int {
        val arr = IntArray(n) {1}
        for (i in 0 until k) {
            for (j in 1 until n)
                arr[j] = (arr[j-1] + arr[j]) % 1000000007
        }

        return arr.last()
    }
}
