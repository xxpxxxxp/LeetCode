package com.ypwang.medium

import com.ypwang.ListNode

class Solution2074 {
    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var cur: ListNode? = dummy
        var len = 1

        while (cur != null) {
            val h = cur
            var i = len
            while (cur!!.next != null && i > 0) {
                cur = cur.next
                i--
            }

            if ((len - i) % 2 == 0) {
                // reverse len
                var j = len-1
                val p = h.next
                var q = p?.next

                while (q != null && j-- > 0) {
                    p!!.next = q.next
                    q.next = h.next
                    h.next = q
                    q = p.next
                }

                cur = p
            }

            len++
        }

        return dummy.next
    }
}

fun main() {
    val l = ListNode(0)
    l.next = ListNode(4)
    l.next!!.next = ListNode(2)
    l.next!!.next!!.next = ListNode(1)
    l.next!!.next!!.next!!.next = ListNode(3)

    Solution2074().reverseEvenLengthGroups(l)
    println(l)
}