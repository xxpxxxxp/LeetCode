package com.ypwang.medium

class Solution3576 {
    fun canMakeEqual(nums: IntArray, k: Int): Boolean =
        listOf(1, -1).any {
            val n = nums.clone()
            var c = 0
            for (i in n.indices) {
                if (n[i] != it) {
                    if (c == k)
                        return@any false

                    c++
                    if (i+1 == n.size)
                        return@any false

                    n[i+1] *= -1
                }
            }

            true
        }
}

fun main() {
    println(Solution3576().canMakeEqual(intArrayOf(1, -1, 1), 2))
}