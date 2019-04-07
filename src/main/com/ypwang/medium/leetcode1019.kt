package com.ypwang.medium

import com.ypwang.ListNode
import java.util.*

class Solution1019 {
    fun nextLargerNodes(head: ListNode?): IntArray {
        val stack = Stack<Pair<Int, Int>>()     // idx, value
        val rst = mutableListOf<Pair<Int, Int>>()       // idx, value
        var idx = 0
        var h = head

        while (h != null) {
            while (!stack.isEmpty() && stack.peek().second < h.`val`) {
                val l = stack.pop()
                rst.add(l.first to h.`val`)
            }
            stack.push(idx to h.`val`)

            h = h.next
            idx++
        }

        while (!stack.isEmpty()) {
            val l = stack.pop()
            rst.add(l.first to 0)
        }

        return rst.sortedBy { it.first }.map { it.second }.toIntArray()
    }
}

fun main() {
    val h = ListNode(2)
    h.next = ListNode(1)
    h.next!!.next = ListNode(5)
    println(Solution1019().nextLargerNodes(h).toList())
}