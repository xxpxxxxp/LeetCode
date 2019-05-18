package com.ypwang.hard

class Solution42 {
    fun trap(height: IntArray): Int {
        var sum = 0
        var h = 0

        var l = 0
        var r = height.lastIndex

        while (l <= r) {
            when {
                height[l] <= h -> l++
                height[r] <= h -> r--
                else -> {
                    val lh = height[l]
                    val rh = height[r]
                    val newH = minOf(lh, rh)
                    sum += (r - l + 1) * (newH - h)
                    h = newH
                }
            }
        }

        return sum - height.sum()
    }
}

fun main() {
    println(Solution42().trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
}