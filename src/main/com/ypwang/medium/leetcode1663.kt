package com.ypwang.medium

class Solution1663 {
    fun getSmallestString(n: Int, k: Int): String {
        val arr = CharArray(n)
        var sum = k

        for (i in 0 until n) {
            val left = 26 * (n - i - 1)
            if (left >= sum)
                arr[i] = 'a'
            else {
                arr[i] = 'a' + sum - left - 1
            }

            sum -= arr[i] - 'a' + 1
        }

        return arr.joinToString("")
    }
}

fun main() {
    println(Solution1663().getSmallestString(3, 27))
    println(Solution1663().getSmallestString(5, 73))
}