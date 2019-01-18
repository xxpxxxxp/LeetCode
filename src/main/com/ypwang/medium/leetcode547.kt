package com.ypwang.medium

class Solution547 {
    fun findCircleNum(M: Array<IntArray>): Int {
        val visiting = BooleanArray(M.size){false}

        fun setFriend(index: Int) {
            if (!visiting[index]) {
                visiting[index] = true
                M[index].withIndex().filter { it.value == 1 }.forEach { setFriend(it.index) }
            }
        }

        var count = 0
        for (i in 0 until M.size) {
            if (!visiting[i]) {
                visiting[i] = true
                count++
                M[i].withIndex().filter { it.value == 1 }.forEach { setFriend(it.index) }
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    println(Solution547().findCircleNum(
            arrayOf(
                    intArrayOf(1,0,0,1),
                    intArrayOf(0,1,1,0),
                    intArrayOf(0,1,1,1),
                    intArrayOf(1,0,1,1)
            )
    ))
}
