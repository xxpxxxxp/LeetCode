package com.ypwang.medium

import com.ypwang.ListNode

class Solution2058 {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var pre = -1
        var cur = -1

        val rst = intArrayOf(Int.MAX_VALUE, -1)

        var node = head!!.next
        var preVal = head.`val`

        var idx = 1
        while (node?.next != null) {
            if ((preVal < node.`val` && node.`val` > node.next!!.`val`) || (preVal > node.`val` && node.`val` < node.next!!.`val`)) {
                if (cur == -1)
                    pre = idx
                else {
                    rst[0] = minOf(rst[0], idx-cur)
                    rst[1] = idx - pre
                }

                cur = idx
            }

            preVal = node.`val`
            idx++
            node = node.next
        }

        if (rst[1] == -1)
            rst[0] = -1

        return rst
    }
}