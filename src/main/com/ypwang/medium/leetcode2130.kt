package com.ypwang.medium

import com.ypwang.ListNode

class Solution2130 {
    fun pairSum(head: ListNode?): Int {
        // reverse head
        val dummy = ListNode(0)
        dummy.next = head

        val p = head!!
        var q = head.next

        val hold = mutableListOf(p.`val`)
        while (q != null) {
            hold.add(q.`val`)

            p.next = q.next
            q.next = dummy.next
            dummy.next = q
            q = p.next
        }

        q = dummy.next
        var idx = 0
        var rst = Int.MIN_VALUE
        while (q != null) {
            rst = maxOf(rst, q.`val` + hold[idx])
            idx++
            q = q.next
        }

        return rst
    }
}