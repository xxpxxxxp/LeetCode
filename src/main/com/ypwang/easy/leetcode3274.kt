package com.ypwang.easy

class Solution3274 {
    private fun helper(c: String): Boolean =
        (c[0] - 'a') % 2 == (c[1] - '1') % 2

    fun checkTwoChessboards(coordinate1: String, coordinate2: String): Boolean =
        helper(coordinate1) == helper(coordinate2)
}
