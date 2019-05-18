package com.ypwang.hard

class Solution786 {
    fun kthSmallestPrimeFraction(A: IntArray, K: Int): IntArray {
        val merge = mutableSetOf<Pair<Int, Int>>()
        merge.add(0 to A.lastIndex)

        var count = 0
        while (true) {
            var min = 1.0
            var pair: Pair<Int, Int> = 0 to 0

            for (p in merge) {
                val t = A[p.first].toDouble() / A[p.second]
                if (t < min) {
                    min = t
                    pair = p
                }
            }

            count++
            if (count == K) return intArrayOf(A[pair.first], A[pair.second])

            merge.remove(pair)

            if (pair.first + 1 == pair.second) continue
            merge.add(pair.first to pair.second - 1)
            if (pair.second == A.lastIndex)
                merge.add(pair.first + 1 to A.lastIndex)
        }
    }
}

fun main() {
    println(Solution786().kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 3))
}