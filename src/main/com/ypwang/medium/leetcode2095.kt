package com.ypwang.medium

import com.ypwang.ListNode

class Solution2095 {
    fun deleteMiddle(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var p= dummy
        var q = head?.next

        while (q != null) {
            q = q.next?.next
            p = p.next!!
        }

        p.next = p.next?.next
        return dummy.next
    }
}