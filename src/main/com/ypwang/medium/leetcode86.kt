package com.ypwang.medium

import com.ypwang.ListNode

class Solution86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val lesser = ListNode(0)
        val bigger = ListNode(0)

        var l = lesser
        var b = bigger
        var cur = head
        while (cur != null) {
            if (cur.`val` < x) {
                // append to lesser
                l.next = cur
                l = l.next!!
            } else {
                // append to bigger
                b.next = cur
                b = b.next!!
            }
            cur = cur.next
        }

        b.next = null
        l.next = bigger.next

        return lesser.next
    }
}

fun main() {
    val root = ListNode(1)
    root.next = ListNode(4)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(2)
    root.next!!.next!!.next!!.next = ListNode(5)
    root.next!!.next!!.next!!.next!!.next= ListNode(2)

    println(Solution86().partition(root, 3))
}