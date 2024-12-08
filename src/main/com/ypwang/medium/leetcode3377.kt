package com.ypwang.medium

import java.util.PriorityQueue

class Solution3377 {
    private val isPrime = BooleanArray(100001) { true }

    fun minOperations(n: Int, m: Int): Int {
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..100000)
            if (isPrime[i])
                for (j in 2 * i..100000 step i)
                    isPrime[j] = false

        if (isPrime[n] || isPrime[m])
            return -1

        val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val visited = mutableSetOf<Int>()

        q.add(Pair(n, n))
        while (q.isNotEmpty()) {
            val (steps, curr) = q.poll()

            if (curr in visited)
                continue

            visited.add(curr)

            if (curr == m)
                return steps

            val s = curr.toString()
            for (i in s.indices) {
                if (s[i] < '9') {
                    val next = s.replaceRange(i..i, (s[i] + 1).toString()).toInt()
                    if (!isPrime[next] && next !in visited)
                        q.add(Pair(steps + next, next))
                }

                if (s[i] > '0' && !(i == 0 && s[i] == '1')) {
                    val next = s.replaceRange(i..i, (s[i] - 1).toString()).toInt()
                    if (!isPrime[next] && next !in visited) {
                        q.add(Pair(steps + next, next))
                    }
                }
            }
        }

        return -1
    }
}
