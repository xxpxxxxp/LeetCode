package com.ypwang.medium

import com.ypwang.ListNode

class Solution2807 {
    private fun gcd(a: Int, b: Int): Int {
        return if (a == 0) b else gcd(b % a, a)
    }

    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var cur = head

        while (cur != null) {
            if (cur.next == null)
                break

            val new = ListNode(gcd(cur.`val`, cur.next!!.`val`))
            new.next = cur.next
            cur.next = new
            cur = new.next
        }

        return head
    }
}