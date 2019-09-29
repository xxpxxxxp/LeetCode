package com.ypwang.medium

import java.util.*

class Solution1208 {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        var rst = Int.MIN_VALUE
        var pre = 0
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(pre to -1)

        for (i in s.indices) {
            pre += Math.abs(s[i] - t[i])
            queue.offer(pre to i)

            while (pre - queue.peek().first > maxCost) queue.poll()
            rst = maxOf(rst, i - queue.peek().second)
        }

        return rst
    }
}