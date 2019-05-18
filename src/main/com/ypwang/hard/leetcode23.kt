package com.ypwang.hard

import com.ypwang.ListNode
import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        val queue = PriorityQueue<ListNode>(kotlin.Comparator { o1, o2 -> o1.`val` - o2.`val` })

        val rst = ListNode(0)
        var head = rst

        queue.addAll(lists.filter { it != null })
        while (queue.isNotEmpty()) {
            val h = queue.remove()
            head.next = h
            head = head.next!!

            if (h.next != null)
                queue.offer(h.next)
        }

        return rst.next
    }
}

fun main() {
    val r1 = ListNode(1)
    r1.next = ListNode(4)
    r1.next!!.next = ListNode(5)

    val r2 = ListNode(1)
    r2.next = ListNode(3)
    r2.next!!.next = ListNode(4)

    val r3 = ListNode(2)
    r3.next = ListNode(6)

    println(Solution23().mergeKLists(arrayOf()))
}