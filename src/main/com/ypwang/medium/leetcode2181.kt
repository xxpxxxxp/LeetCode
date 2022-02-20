package com.ypwang.medium

import com.ypwang.ListNode

class Solution2181 {
    fun mergeNodes(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var pre = dummy

        var cur = head?.next
        while (cur != null) {
            var sum = 0
            while (cur != null && cur.`val` != 0) {
                sum += cur.`val`
                cur = cur.next
            }

            if (sum != 0) {
                pre.next = ListNode(sum)
                pre = pre.next!!
            }

            cur = cur?.next
        }

        return dummy.next
    }
}