package com.ypwang.medium

import com.ypwang.ListNode

class Solution61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        // get len
        var p = head
        var c = 0
        while (p != null) {
            p = p.next
            c++
        }

        if (c == 0 || k % c == 0) {
            return head
        }

        var d = k % c

        p = head
        var q = head
        while (d > 0) {
            q = q!!.next
            d--
        }

        while (q?.next != null) {
            p = p!!.next
            q = q.next
        }

        val newhead = p!!.next
        p.next = null
        q!!.next = head

        return newhead
    }
}

fun main() {
    val root = ListNode(1)
    root.next = ListNode(2)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(4)
    root.next!!.next!!.next!!.next = ListNode(5)
    println(Solution61().rotateRight(null, 5))
}