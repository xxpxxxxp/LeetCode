package com.ypwang.medium

import com.ypwang.ListNode

class Solution328 {
    fun oddEvenList(head: ListNode?): ListNode? {
        val h = head
        var odd: ListNode = h ?: return h
        val evenh = h.next
        var even = evenh

        while (even?.next != null) {
            odd.next = even.next
            even.next = even.next!!.next
            odd = odd.next!!
            even = even.next
        }
        odd.next = evenh

        return h
    }
}

fun main(args: Array<String>) {
    val root = ListNode(1)
    root.next = ListNode(2)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(4)
    root.next!!.next!!.next!!.next = ListNode(5)

    var exchange = Solution328().oddEvenList(root)
    while (exchange != null) {
        println(exchange.`val`)
        exchange = exchange.next
    }
}