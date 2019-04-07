package com.ypwang.medium

class Solution397 {
    fun integerReplacement(n: Int): Int {
        if (n == 1)
            return 0

        if (n == Int.MAX_VALUE)
            return 32

        val seen = mutableSetOf(n)
        var current = setOf(n)
        var step = 1

        while (true) {
            seen.addAll(current)
            val next = mutableSetOf<Int>()
            for (x in current) {
                when (x % 2) {
                    0 -> {
                        val t = x / 2
                        if (t == 1)
                            return step

                        if (t !in seen && t > 0)
                            next.add(t)
                    }
                    1 -> {
                        val p = x + 1
                        val q = x - 1
                        if (p == 1 || q == 1)
                            return step

                        if (p !in seen)
                            next.add(p)

                        if (q !in seen && q > 0)
                            next.add(q)
                    }
                }
            }
            step++
            current = next
        }
    }
}

fun main() {
    println(Solution397().integerReplacement(2147483647))
}