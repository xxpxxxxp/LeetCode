package com.ypwang.easy

class Solution3963 {
    fun createGrid(m: Int, n: Int): Array<String> {
        val rst = mutableListOf<String>()
        rst.add((0 until n).map { '.' }.joinToString(""))
        for (i in 1 until m) {
            rst.add((1 until n).map { '#' }.joinToString("") + ".")
        }

        return rst.toTypedArray()
    }
}
