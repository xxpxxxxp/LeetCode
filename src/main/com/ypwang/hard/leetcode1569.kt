package com.ypwang.hard

import java.math.BigInteger

class Solution1569 {
    private val mod = 1000000007
    private fun combination(base: Int, pos: Int): Int {
        val b = BigInteger.valueOf(base.toLong())
        val p = BigInteger.valueOf(minOf(pos, base - pos).toLong())

        var rst = BigInteger.ONE
        var i = b - p + BigInteger.ONE
        var j = BigInteger.valueOf(2L)

        while (i <= b) {
            rst *= i
            i++

            while (j <= p && rst % j == BigInteger.ZERO) {
                rst /= j
                j++
            }
        }

        return (rst % BigInteger.valueOf(mod.toLong())).toInt()
    }

    fun possibilitys(nums: IntArray): Int {
        if (nums.size < 2) return 1
        val head = nums.first()
        val smaller = nums.filter { it < head }.toIntArray()
        val bigger = nums.filter { it > head }.toIntArray()

        return (
                    (
                        (
                            (possibilitys(smaller).toLong() * possibilitys(bigger)) % mod
                        ) * combination(smaller.size + bigger.size, smaller.size)
                    ) % mod
                ).toInt()
    }

    fun numOfWays(nums: IntArray): Int = (possibilitys(nums) + mod - 1) % mod
}

fun main() {
    println(Solution1569().numOfWays(intArrayOf(19,3,57,34,15,89,58,35,2,33,46,13,40,79,60,30,61,26,54,22,84,51,75,6,87,44,55,48,27,8,72,47,16,69,36,76,41,1,80,62,73,24,93,50,92,65,39,5,32,67,12,29,90,45,9,38,88,52,10,85,74,66,83,18,20,77,49,28,23,53,86,64,78,82,37,42,56,17,81,4,14,70,59,31,7,25,43,68,91,71,21,63,94,11)))
    println(Solution1569().numOfWays(intArrayOf(2,1,3)))
    println(Solution1569().numOfWays(intArrayOf(3,4,5,1,2)))
    println(Solution1569().numOfWays(intArrayOf(1,2,3)))
    println(Solution1569().numOfWays(intArrayOf(3,1,2,5,4,6)))
    println(Solution1569().numOfWays(intArrayOf(9,4,2,1,3,6,5,7,8,14,11,10,12,13,16,15,17,18)))
}