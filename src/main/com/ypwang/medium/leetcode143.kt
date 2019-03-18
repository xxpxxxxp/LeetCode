package com.ypwang.medium

import com.ypwang.ListNode

class Solution143 {
    fun reorderList(head: ListNode?): Unit {
        if (head == null)
            return

        var begin: ListNode = head
        var follow = head

        while (follow?.next?.next != null) {
            begin = begin.next!!
            follow = follow.next?.next
        }

        var followHead = begin.next

        // reverse even
        val dummy = ListNode(0)
        dummy.next = followHead

        var pre = followHead
        var n = pre?.next

        while (n != null) {
            pre!!.next = n.next
            n.next = dummy.next
            dummy.next = n

            n = pre.next
        }

        followHead = dummy.next

        // put together
        var h: ListNode = head
        while (followHead != null) {
            val t = h.next!!
            h.next = followHead
            followHead = followHead.next
            h.next!!.next = t
            h = t
        }
        h.next = null

        return
    }
}

fun main(args: Array<String>) {
    val root= ListNode(0)
    root.next = ListNode(1)
    root.next!!.next = ListNode(2)
    root.next!!.next!!.next = ListNode(3)
    root.next!!.next!!.next!!.next = ListNode(4)

    println(Solution143().reorderList(root))
}