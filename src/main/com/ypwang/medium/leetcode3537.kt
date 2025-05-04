package com.ypwang.medium

class Solution3537 {
    fun specialGrid(N: Int): Array<IntArray> {
        val len = 1 shl N
        val rst = Array(len) { IntArray(len) }

        fun fill(x: Int, y: Int, v: Int, l: Int) {
            if (l == 1)
                rst[x][y] = v
            else {
                val nl = l / 2
                fill(x, y + nl, v, nl)
                fill(x + nl, y + nl, v + nl * nl, nl)
                fill(x + nl, y, v + 2 * nl * nl, nl)
                fill(x, y, v + 3 * nl * nl, nl)
            }
        }

        fill(0, 0, 0, len)
        return rst
    }
}

fun main() {
    Solution3537().specialGrid(2).map {
        println(it.joinToString(","))
    }
}
