package com.ypwang.medium

class Solution1222 {
    fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
        val set = queens.map { (it[0] shl 3) or it[1] }.toSet()
        val rst = mutableListOf<List<Int>>()

        val dec = listOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1)
        for ((x, y) in dec) {
            var i = 0
            while (true) {
                i++
                val tx = king[0] - i*x
                val ty = king[1] - i*y
                if (tx !in 0..7 || ty !in 0..7) break
                if ((tx shl 3) or ty in set) {
                    rst.add(listOf(tx, ty))
                    break
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1222().queensAttacktheKing(
            arrayOf(intArrayOf(0,1),intArrayOf(1,0),intArrayOf(4,0),intArrayOf(0,4),intArrayOf(3,3),intArrayOf(2,4)), intArrayOf(0,0)
    ))
}