package com.ypwang.easy

class Solution1030 {
    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        val rst = mutableListOf(intArrayOf(r0, c0))

        var i = 1
        while (true) {
            var count = 0

            for (j in 0 until i) {
                val k = i - j
                // let's try [j, i-j] as increment
                // j >= 0, k > 0
                if (r0 - j >= 0 && c0 + k < C) {
                    rst.add(intArrayOf(r0-j, c0+k))
                    count++
                }

                if (r0 + k < R && c0 + j < C) {
                    rst.add(intArrayOf(r0+k, c0+j))
                    count++
                }

                if (r0 + j < R && c0 - k >= 0) {
                    rst.add(intArrayOf(r0+j, c0-k))
                    count++
                }

                if (r0 - k >= 0 && c0 - j >= 0) {
                    rst.add(intArrayOf(r0-k, c0-j))
                    count++
                }
            }

            if (count == 0)
                return rst.toTypedArray()

            i++
        }
    }
}

fun main() {
    println(Solution1030().allCellsDistOrder(1,2,0,0).map { it.toList() })
}