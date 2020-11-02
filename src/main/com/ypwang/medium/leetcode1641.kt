package com.ypwang.medium

class Solution1641 {
    fun countVowelStrings(n: Int): Int =
        (1 until n).fold(intArrayOf(1,1,1,1,1)) { arr, _ ->
            intArrayOf(
                    arr[0],
                    arr[0] + arr[1],
                    arr[0] + arr[1] + arr[2],
                    arr[0] + arr[1] + arr[2] + arr[3],
                    arr[0] + arr[1] + arr[2] + arr[3] + arr[4]
            )
        }.sum()
}

fun main() {
    println(Solution1641().countVowelStrings(2))
}