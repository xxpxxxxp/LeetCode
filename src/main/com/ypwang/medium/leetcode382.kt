package com.ypwang.medium

import com.ypwang.ListNode
import java.util.*

class Solution382(val head: ListNode?) {

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */


    /** Returns a random node's value. */
    fun getRandom(): Int {
        val rand = Random()

        var len = 1
        var cur = head!!
        var rst = cur.`val`
        while (cur.next != null) {
            len += 1

            if (rand.nextInt(len) == 0) {
                rst = cur.next!!.`val`
            }

            cur = cur.next!!
        }

        return rst
    }

}