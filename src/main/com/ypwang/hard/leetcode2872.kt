package com.ypwang.hard

import java.util.*

class Solution2872 {
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        val conn = Array(n) { mutableListOf<Int>() }
        val cnt = IntArray(n)
        var rst = 0
        for ((a, b) in edges) {
            conn[a].add(b)
            conn[b].add(a)
        }
        val queue: Queue<Int> = LinkedList()
        for (i in 0 until n) {
            cnt[i] = conn[i].size
            if (cnt[i] < 2)
                queue.offer(i)
        }

        while (queue.isNotEmpty()) {
            val i = queue.poll()
            cnt[i]--
            if (values[i] % k == 0)
                rst++

            for (j in conn[i]) {
                if (cnt[j] != 0) {
                    values[j] += values[i] % k
                    if (--cnt[j] == 1)
                        queue.offer(j)
                }
            }
        }

        return rst
    }
}