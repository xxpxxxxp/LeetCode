package com.ypwang.medium

import com.ypwang.ListNode

class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var f = dummy
        var b: ListNode? = head
        for (i in 0 until n) {
            b = b!!.next
        }

        while (b != null) {
            b = b.next
            f = f.next!!
        }

        f.next = f.next!!.next

        return dummy.next
    }
}

fun main(args: Array<String>) {
    val r = ListNode(1)
    r.next = ListNode(2)
    println(Solution19().removeNthFromEnd(r, 1))
}