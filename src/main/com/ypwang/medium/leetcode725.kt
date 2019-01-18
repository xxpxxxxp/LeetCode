package com.ypwang.medium

import com.ypwang.ListNode

class Solution725 {
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        var count = 0
        var cur = root
        while (cur != null) {
            count++
            cur = cur.next
        }

        var slice = Math.ceil(count.toDouble() / k).toInt()
        var piece = k

        val rst = mutableListOf<ListNode?>()
        var slip = root
        var c = 0
        while (slip != null) {
            if (c == 0) {
                rst.add(slip)
            }

            c++
            if (c == slice) {
                c = 0
                piece--
                count -= slice
                slice = Math.ceil(count.toDouble() / piece).toInt()
                // cut
                val n = slip.next
                slip.next = null
                slip = n
            } else {
                slip = slip.next
            }
        }

        val last = k - rst.size
        (0 until last).forEach { rst.add(null) }

        return rst.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val root = ListNode(0)
    var tmp = root
    for (i in 1..3) {
        tmp.next = ListNode(i)
        tmp = tmp.next!!
    }

    val rst = Solution725().splitListToParts(root, 4)
}