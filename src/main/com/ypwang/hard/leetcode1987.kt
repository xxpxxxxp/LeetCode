package com.ypwang.hard

class Solution1987 {
    fun numberOfUniqueGoodSubsequences(binary: String): Int =
        (binary.fold(intArrayOf(0, 0)) { arr, c ->
            arr[c - '0'] = (arr.sum() + (c - '0')) % 1000000007
            arr
        }.sum() + (if ('0' in binary) 1 else 0)) % 1000000007
}