package com.ypwang.hard

class Solution2151 {
    fun maximumGood(statements: Array<IntArray>): Int =
        (1 until (1 shl statements.size))
            .filter { mask ->
                for (i in statements.indices) {
                    if (mask and (1 shl i) > 0) {
                        for ((j, v) in statements[i].withIndex()) {
                            when (v) {
                                1 -> if (mask and (1 shl j) == 0) return@filter false
                                0 -> if (mask.inv() and (1 shl j) == 0) return@filter false
                            }
                        }
                    }
                }

                true
            }
            .map { Integer.bitCount(it) }
            .maxOrNull() ?: 0
}