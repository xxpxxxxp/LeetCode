package com.ypwang.medium

import com.ypwang.ListNode

class Solution92 {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var h = dummy

        for (i in 0 until m - 1) {
            h = h.next!!
        }

        // reverse
        var count = n - m

        val p = h
        val q = p.next!!
        var m = q.next

        while (count > 0) {
            val t = p.next
            q.next = m?.next
            p.next = m
            m!!.next = t
            m = q.next
            count--
        }

        return dummy.next
    }
}

fun main() {
    val root = ListNode(1)
    root.next = ListNode(2)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(4)
    root.next!!.next!!.next!!.next = ListNode(5)

    println(Solution92().reverseBetween(root, 1, 2))
}