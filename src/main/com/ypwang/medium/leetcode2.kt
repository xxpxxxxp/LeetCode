package com.ypwang.medium

import com.ypwang.ListNode

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val root = ListNode(0)

        var n: ListNode = root
        var carry = 0

        var l1c = l1
        var l2c = l2
        while (l1c != null && l2c != null) {
            val v = l1c.`val` + l2c.`val` + carry
            n.next = ListNode(v % 10)
            n = n.next!!
            carry = v / 10

            l1c = l1c.next
            l2c = l2c.next
        }

        var follow = l1c ?: l2c

        while (follow != null) {
            val v = follow.`val` + carry
            n.next = ListNode(v % 10)
            n = n.next!!
            carry = v / 10
            follow = follow.next
        }

        if (carry != 0) {
            n.next = ListNode(1)
        }

        return root.next
    }
}

fun main(args: Array<String>) {
    val l1 = ListNode(5)
    val l2 = ListNode(5)

    var l3 = Solution2().addTwoNumbers(l1, l2)
    while (l3 != null) {
        println(l3.`val`)
        l3 = l3.next
    }
}