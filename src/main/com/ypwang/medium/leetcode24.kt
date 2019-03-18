package com.ypwang.medium

import com.ypwang.ListNode

class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var p1 = dummy
        var p2 = p1.next
        var p3 = p2?.next

        while (p3 != null) {
            p1.next = p3
            p2!!.next = p3.next
            p3.next = p2

            p1 = p2
            p2 = p1.next
            p3 = p2?.next
        }

        return dummy.next
    }
}