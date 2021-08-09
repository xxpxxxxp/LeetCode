package com.ypwang.hard

import java.util.*

class Solution1960 {
    fun maxProduct(s: String): Long {
        val m = IntArray(s.length)

        var l = 0
        var r = -1

        // Manacher's Algorithm (https://cp-algorithms.com/string/manacher.html)
        for (i in s.indices) {
            var k = if (i > r) 1 else minOf(m[l + r - i], r - i + 1)
            while (i - k >= 0 && i + k < s.length && s[i-k] == s[i+k])
                k++

            m[i] = k--
            if (i + k > r) {
                l = i-k
                r = i+k
            }
        }

        val q: Queue<IntArray> = LinkedList()
        val rr = IntArray(s.length)

        for (i in s.indices.reversed()) {
            while (q.isNotEmpty() && q.peek()[0] - q.peek()[1] > i-1)
                q.poll()

            rr[i] = 1 + if (q.isEmpty()) 0 else (q.peek()[0] - i) * 2
            q.offer(intArrayOf(i, m[i]))
        }

        var rst = 0L
        var ll = Long.MIN_VALUE
        q.clear()
        for (i in 0 until s.lastIndex) {
            while (q.isNotEmpty() && q.peek()[0] + q.peek()[1] < i+1)
                q.poll()

            ll = maxOf(ll, 1L + if (q.isEmpty()) 0 else (i - q.peek()[0]) * 2)
            rst = maxOf(rst, ll * rr[i+1])
            q.offer(intArrayOf(i, m[i]))
        }

        return rst
    }
}

fun main() {
    println(Solution1960().maxProduct("ababbb"))
    println(Solution1960().maxProduct("zaaaxbbby"))
}