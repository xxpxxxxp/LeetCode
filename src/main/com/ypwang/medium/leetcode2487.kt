package com.ypwang.medium

import com.ypwang.ListNode
import java.util.*

class Solution2487 {
    fun removeNodes(head: ListNode?): ListNode? {
        val stk: Stack<ListNode> = Stack()
        var h = head
        while (h != null) {
            stk.push(h)
            h = h.next
        }

        var pre: ListNode? = null
        var max = Int.MIN_VALUE
        while (stk.isNotEmpty()) {
            val n = stk.pop()
            if (n.`val` < max)
                continue

            n.next = pre
            pre = n
            max = maxOf(max, pre.`val`)
        }

        return pre
    }
}

fun main() {
    // [5,2,13,3,8]
    val root = ListNode(5)
    root.next = ListNode(2)
    root.next!!.next = ListNode(13)
    root.next!!.next!!.next = ListNode(3)
    root.next!!.next!!.next!!.next = ListNode(8)
}