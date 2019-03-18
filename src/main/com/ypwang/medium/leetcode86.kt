package com.ypwang.medium

import com.ypwang.ListNode

class Solution86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var p: ListNode? = null
        var q: ListNode? = null
        var hp: ListNode? = null
        var hq: ListNode? = null

        var h = head

        while (h != null) {
            if (h.`val` < x) {
                if (p == null) {
                    hp = h
                    p = h
                }
                else {
                    p.next = h
                    p = h
                }
            } else {
                if (q == null) {
                    hq = h
                    q = h
                }
                else {
                    q.next = h
                    q = h
                }
            }
            h = h.next
        }
        return if (p == null) hq
        else {
            p.next = hq
            hp
        }
    }
}

fun main(args: Array<String>) {
    val root = ListNode(1)
    root.next = ListNode(4)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(2)
    root.next!!.next!!.next!!.next = ListNode(5)
    root.next!!.next!!.next!!.next!!.next= ListNode(2)

    println(Solution86().partition(root, 3))
}