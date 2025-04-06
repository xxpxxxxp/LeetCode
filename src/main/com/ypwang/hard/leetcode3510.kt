package com.ypwang.hard

import java.util.*

class Solution3510 {
    private var inversions = 0

    fun minimumPairRemoval(nums: IntArray): Int {
        val ns = nums.map { it.toLong() }.toLongArray()
        val N = ns.size
        val L = IntArray(N) { it - 1 }
        val R = IntArray(N) { it + 1 }

        inversions = (0 until N - 1).count { ns[it] > ns[it + 1] }

        val S = TreeSet<Pair<Long, Int>>(compareBy({ it.first }, { it.second }))
        for (i in 0 until N - 1)
            S.add(Pair(ns[i].toLong() + ns[i + 1], i))

        fun add(i: Int) {
            if (i < 0)
                return
            val j = R[i]
            if (i < j && j < N) {
                S.add(Pair(ns[i].toLong() + ns[j], i))
                if (ns[i] > ns[j])
                    inversions++
            }
        }

        fun remove(i: Int) {
            if (i < 0)
                return
            val j = R[i]
            if (i < j && j < N) {
                S.remove(Pair(ns[i].toLong() + ns[j], i))
                if (ns[i] > ns[j])
                    inversions--
            }
        }

        var ans = 0
        while (inversions > 0) {
            ans++
            val (_, i) = S.pollFirst()!!
            val j = R[i]
            val h = L[i]
            val k = if (j < N) R[j] else N

            remove(h)
            remove(i)
            remove(j)

            ns[i] += ns[j]
            ns[j] = -10000000
            R[i] = k
            if (k < N) L[k] = i

            add(h)
            add(i)
        }

        return ans
    }
}

fun main() {
    println(Solution3510().minimumPairRemoval(intArrayOf(2,2,-1,3,-2,2,1,1,1,0,-1)))
}