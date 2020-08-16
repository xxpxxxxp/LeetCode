package com.ypwang.medium

class Solution1552 {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()

        fun eval(len: Int): Boolean {
            var count = 0
            var cur = position[0]
            for (pos in position) {
                if (pos - cur >= len) {
                    count++
                    cur = pos
                    if (count == m-1)
                        return true
                }
            }

            return false
        }

        var l = 1
        var r = 1000000000

        while (l < r) {
            val mid = (l + r + 1) / 2
            if (eval(mid)) l = mid
            else r = mid - 1
        }

        return l
    }
}

fun main() {
    println(Solution1552().maxDistance(intArrayOf(1,2,3,4,7), 3))
    println(Solution1552().maxDistance(intArrayOf(5,4,3,2,1,1000000000), 2))
}