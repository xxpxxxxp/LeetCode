package com.ypwang.medium

class Solution885 {
    class TI : Iterator<Int> {
        var cur = 1
        var count = 0
        override fun next(): Int {
            val r = cur
            if (count > 0) {
                cur++
                count = 0
            } else {
                count++
            }
            return r
        }

        override fun hasNext(): Boolean {
            return true
        }

    }

    fun spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        val rst = mutableListOf<IntArray>()
        var direction = 0  // to right

        var curX = c0
        var curY = r0
        for (l in TI()) {
            if (rst.size == R * C) {
                return rst.toTypedArray()
            }

            for (i in 0 until l) {
                if (curX in 0 until C && curY in 0 until R) {
                    rst.add(intArrayOf(curY, curX))
                }

                when (direction) {
                    0 -> curX++  // go right
                    1 -> curY++  // go down
                    2 -> curX--  // go left
                    3 -> curY--  // go up
                    else -> {}
                }
            }

            direction = (direction + 1) % 4
        }
        return arrayOf()
    }
}

fun main(args: Array<String>) {
    println(Solution885().spiralMatrixIII(1, 4, 0, 0).map { it.toList() }.toList())
}