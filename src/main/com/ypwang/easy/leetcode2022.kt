package com.ypwang.easy

class Solution2022 {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> =
        if (original.size != m * n)
            arrayOf()
        else
            Array(m) { r ->
                IntArray(n) { c ->
                    original[r * n + c]
                }
            }
}