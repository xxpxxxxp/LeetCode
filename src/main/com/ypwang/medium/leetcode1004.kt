package com.ypwang.medium

class Solution1004 {
    fun longestOnes(A: IntArray, K: Int): Int {
        var k = K
        // we keep window l..cur index the widest as we go
        var l = 0

        for (a in A) {
            if (a == 0)
                // we meet 0, need to use 1 chance to change it to 1
                k--

            if (k < 0) {
                // we used up chances, cannot grow the window anymore, move left side to right
                if (A[l] == 0) {
                    // as we move window, return 1 chance back
                    k++
                }
                l++
            }
        }

        return A.size - l
    }
}