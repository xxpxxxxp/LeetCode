package com.ypwang.hard

class Solution1284 {
    fun minFlips(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size

        var initial = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                initial = initial or (mat[i][j] shl (i * 3 + j))
            }
        }

        if (initial == 0) return 0

        val seen = mutableSetOf<Int>()
        var cur = listOf(initial)
        var step = 0
        while (cur.isNotEmpty()) {
            seen.addAll(cur)
            step++

            val next = mutableListOf<Int>()
            for (v in cur) {
                for (i in 0 until m) {
                    for (j in 0 until n) {
                        // flip it
                        var b = v
                        for ((x, y) in listOf(0 to 0, -1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
                            val ii = i + x
                            val jj = j + y
                            if (ii in 0 until m && jj in 0 until n) {
                                b = b xor (1 shl (ii * 3 + jj))
                            }
                        }
                        if (b == 0) return step
                        if (b !in seen) next.add(b)
                    }
                }
            }
            cur = next
        }

        return -1
    }
}

fun main() {
    println(Solution1284().minFlips(arrayOf(intArrayOf(0,0), intArrayOf(0,1))))
    println(Solution1284().minFlips(arrayOf(intArrayOf(0))))
    println(Solution1284().minFlips(arrayOf(intArrayOf(1,1,1), intArrayOf(1,0,1), intArrayOf(0,0,0))))
    println(Solution1284().minFlips(arrayOf(intArrayOf(1,0,0), intArrayOf(1,0,0))))
}