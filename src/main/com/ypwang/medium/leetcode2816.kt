package com.ypwang.medium

import com.ypwang.ListNode
import java.util.*

class Solution2816 {
    fun doubleIt(head: ListNode?): ListNode? {
        val stack = Stack<ListNode>()

        var cur = head
        while (cur != null) {
            stack.add(cur)
            cur = cur.next
        }

        var inc = 0
        while (stack.isNotEmpty()) {
            val c = stack.pop()
            val v = 2 * c.`val` + inc
            if (v >= 10)
                inc = 1
            else
                inc = 0

            c.`val` = v % 10
        }

        if (inc > 0) {
            val t = ListNode(1)
            t.next = head
            return t
        }

        return head
    }
}