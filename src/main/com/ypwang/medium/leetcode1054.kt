package com.ypwang.medium

class Solution1054 {
    fun rearrangeBarcodes(barcodes: IntArray): IntArray {
        val order = barcodes.groupBy { it }.mapValues { it.value.size }.toList().sortedByDescending { it.second }.flatMap {
            p -> List(p.second){p.first}
        }.iterator()

        var idx = 0
        for (i in 0 until barcodes.size) {
            barcodes[idx] = order.next()
            idx += 2
            if (idx >= barcodes.size) {
                idx -= if (barcodes.size % 2 == 0) barcodes.size - 1 else barcodes.size
            }
        }

        return barcodes
    }
}

fun main() {
    println(Solution1054().rearrangeBarcodes(intArrayOf(2,2,1,3)).toList())
}