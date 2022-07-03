package com.ypwang.medium

import com.ypwang.ListNode

class Solution2326 {
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        val rst = Array(m) { IntArray(n) { -1 } }

        var i = 0
        var j = 0
        var di = 0
        var dj = 1

        var cur = head
        while (cur != null) {
            rst[i][j] = cur.`val`
            if (i + di < 0 || i + di == m || j + dj < 0 || j + dj == n || rst[i + di][j + dj] != -1) {
                val t = di
                di = dj
                dj = -t
            }

            i += di
            j += dj

            cur = cur.next
        }
        return rst
    }
}