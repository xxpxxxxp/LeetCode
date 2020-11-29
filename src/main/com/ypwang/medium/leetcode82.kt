package com.ypwang.medium

import com.ypwang.ListNode

class Solution82 {
    fun dedup(h: ListNode): ListNode? {
        var head: ListNode? = h
        while (head?.next != null && head.next!!.`val` == head.`val`) {
            while (head?.next != null && head!!.next!!.`val` == head.`val`) {
                head = head.next!!
            }
            head = head?.next
        }

        return head
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val dummy = ListNode(0)
        dummy.next = head

        var p: ListNode? = dummy
        var h = head

        while (h != null) {
            p!!.next = dedup(h)
            p = p.next
            h = p?.next
        }

        return dummy.next
    }
}

fun main() {
    val root = ListNode(1)
    root.next = ListNode(1)
//    root.next!!.next = ListNode(3)
//    root.next!!.next!!.next = ListNode(3)
//    root.next!!.next!!.next!!.next = ListNode(4)
//    root.next!!.next!!.next!!.next!!.next = ListNode(4)
//    root.next!!.next!!.next!!.next!!.next!!.next = ListNode(5)
    println(Solution82().deleteDuplicates(root))
}