package com.ypwang.hard

import java.util.*

class Solution786 {
    fun kthSmallestPrimeFraction(A: IntArray, K: Int): IntArray {
        A.sort()
        val p = PriorityQueue<Triple<Int, Int, Double>>(Comparator{t1, t2 -> t1.third.compareTo(t2.third) })
        for ((i, v) in A.withIndex()) {
            p.add(Triple(i, A.lastIndex, v.toDouble() / A.last()))
        }

        for (i in 1 until K) {
            val (x, y, _) = p.poll()
            if (y > 1) p.add(Triple(x, y-1, A[x].toDouble() / A[y-1]))
        }

        return p.poll().let { intArrayOf(A[it.first], A[it.second]) }
    }
}

fun main() {
    println(Solution786().kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 3).toList())
    println(Solution786().kthSmallestPrimeFraction(intArrayOf(1, 7), 1).toList())
}