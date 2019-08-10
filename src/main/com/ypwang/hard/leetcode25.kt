package com.ypwang.hard

import com.ypwang.ListNode

class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var h = dummy
        label@ while (h.next != null) {
            var i = 1
            var t = h.next
            while (i < k) {
                t = t!!.next
                if (t == null)
                    break@label
                i++
            }

            i = 1
            val p = h.next!!
            var q = p.next

            while (i < k && q != null) {
                p.next = q.next
                q.next = h.next
                h.next = q
                i++
                q = p.next
            }

            h = p
        }

        return dummy.next
    }
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next = ListNode(6)
    println(Solution25().reverseKGroup(head, 3))
}