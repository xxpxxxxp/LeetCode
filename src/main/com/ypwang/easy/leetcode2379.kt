package com.ypwang.easy

class Solution2379 {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var c = 0
        for (i in 0 until k) {
            if (blocks[i] == 'W')
                c++
        }

        var rst = c
        for (i in k until blocks.length) {
            if (blocks[i-k] == 'W')
                c--
            if (blocks[i] == 'W')
                c++
            rst = minOf(rst, c)
        }
        return rst
    }
}

fun main() {
    println(Solution2379().minimumRecolors("WBBWWBBWBW",7))
}