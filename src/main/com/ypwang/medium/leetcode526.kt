package com.ypwang.medium

class Solution526 {
    fun countArrangement(N: Int): Int {
        var count = 0
        fun helper(pos: Int, used: MutableSet<Int>) {
            if (pos > N) {
                count++
                return
            }

            for (i in 1..N) {
                if (i !in used && (i % pos == 0 || pos % i == 0)) {
                    used.add(i)
                    helper(pos+1, used)
                    used.remove(i)
                }
            }
        }

        if (N < 1) {
            return 0
        }
        helper(1, mutableSetOf())
        return count
    }
}

fun main(args: Array<String>) {
    println(Solution526().countArrangement(4))
}