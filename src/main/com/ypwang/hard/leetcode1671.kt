package com.ypwang.hard

class Solution1671 {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val pos = IntArray(nums.size)
        val rev = IntArray(nums.size)
        val lis = IntArray(nums.size)

        var len = 0
        for ((j, c) in nums.withIndex()) {
            var i = lis.binarySearch( c, 0, len)
            if (i < 0) {
                i = -(i + 1)
            }
            lis[i] = c
            pos[j] = i
            if (i == len) {
                len++
            }
        }

        lis.fill(0)
        len = 0
        for ((j, c) in nums.withIndex().reversed()) {
            var i = lis.binarySearch( c, 0, len)
            if (i < 0) {
                i = -(i + 1)
            }
            lis[i] = c
            rev[j] = i
            if (i == len) {
                len++
            }
        }

        return nums.size - 1 - (pos.zip(rev).filter { it.first > 0 && it.second > 0 }.map { it.first + it.second }.max() ?: 0)
    }
}

fun main() {
    println(Solution1671().minimumMountainRemovals(intArrayOf(9,8,1,7,6,5,4,3,2,1)))
    println(Solution1671().minimumMountainRemovals(intArrayOf(1,3,1)))
    println(Solution1671().minimumMountainRemovals(intArrayOf(2,1,1,5,6,2,3,1)))
    println(Solution1671().minimumMountainRemovals(intArrayOf(4,3,2,1,1,2,3,1)))
    println(Solution1671().minimumMountainRemovals(intArrayOf(1,2,3,4,4,3,2,1)))
}