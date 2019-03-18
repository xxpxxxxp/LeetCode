package com.ypwang.medium

import com.ypwang.ListNode

class Solution148 {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null)
            return head

        var fast: ListNode = head
        var slow: ListNode = head

        while (fast.next?.next != null) {
            fast = fast.next!!.next!!
            slow = slow.next!!
        }

        var after = sortList(slow.next)
        slow.next = null
        var before = sortList(head)

        val newHead = ListNode(0)
        var p = newHead

        while (before != null && after != null) {
            if (before.`val` < after.`val`) {
                p.next = before
                before = before.next
            } else {
                p.next = after
                after = after.next
            }
            p = p.next!!
        }

        if (before != null)
            p.next = before
        else
            p.next = after

        return newHead.next
    }
}

fun main(args: Array<String>) {
    val root= ListNode(-1)
    root.next = ListNode(5)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(4)
    root.next!!.next!!.next!!.next = ListNode(0)

    println(Solution148().sortList(root))
}