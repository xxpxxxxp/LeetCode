package com.ypwang.medium

import com.ypwang.ListNode

class Solution147 {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null)
            return null

        var unsorted = head.next
        var sorted: ListNode = head
        sorted.next = null

        while (unsorted != null) {
            val take: ListNode = unsorted
            unsorted = unsorted.next

            if (take.`val` < sorted.`val`) {
                take.next = sorted
                sorted = take
            } else {
                var pre = sorted
                var n = pre.next

                while (n != null) {
                    if (take.`val` < n.`val`) {
                        break
                    }
                    pre = n
                    n = n.next
                }
                pre.next = take
                take.next = n
            }
        }

        return sorted
    }
}

fun main(args: Array<String>) {
    val root= ListNode(-1)
    root.next = ListNode(5)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(4)
    root.next!!.next!!.next!!.next = ListNode(0)

    println(Solution147().insertionSortList(root))
}