package com.ypwang.medium

import com.ypwang.ListNode

class Solution1171 {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val faked = ListNode(0)
        faked.next = head
        val map = mutableMapOf(0 to faked)

        var cur = head
        var sum = 0
        while (cur != null) {
            sum += cur.`val`

            if (sum in map) {
                val pre = map[sum]!!
                // remove nodes from pre to cur
                var i = pre.next!!
                var t = sum
                while (i != cur) {
                    t += i.`val`
                    map.remove(t)
                    i = i.next!!
                }
                pre.next = cur.next
            } else {
                map[sum] = cur

            }
            cur = cur.next
        }

        return faked.next
    }
}

fun main() {
    val root = ListNode(1)
    root.next = ListNode(2)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(-3)
    root.next!!.next!!.next!!.next = ListNode(-2)

    val t = Solution1171().removeZeroSumSublists(root)
    println(t)
}