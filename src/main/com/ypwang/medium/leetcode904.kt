package com.ypwang.medium

class Solution904 {
    fun totalFruit(tree: IntArray): Int {
        val cur = intArrayOf(tree.last(), 1)
        var another: Int? = null
        var size = 1
        var max = 1

        for (i in tree.lastIndex - 1 downTo 0) {
            if (tree[i] == cur[0]) {
                size += 1
                cur[1] += 1
            } else {
                if (another == null || another == tree[i]) {
                    size += 1
                }
                else {
                    size = cur[1] + 1
                }
                another = cur[0]
                cur[0] = tree[i]
                cur[1] = 1
            }

            if (size > max) max = size
        }

        return max
    }
}

fun main() {
    println(Solution904().totalFruit(intArrayOf(3,3,3,1,2,1,1,2,3,3,4)))
}