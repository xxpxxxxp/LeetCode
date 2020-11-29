package com.ypwang.easy

class Solution832 {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        val B = A.clone()
        for (row in B) {
            val len = row.size
            for (i in 0..(len/2-1)) {
                val tmp = row[i]
                row[i] = 1 - row[len-i-1]
                row[len-i-1] = 1 - tmp
            }
            if (len%2 == 1) {
                row[len/2] = 1-row[len/2]
            }
        }
        return B
    }
}

fun main() {
    println(Solution832().flipAndInvertImage(arrayOf(intArrayOf(1,1,0), intArrayOf(1,0,1), intArrayOf(0,0,0))))
}