package com.ypwang.medium

class Solution1027 {
    fun longestArithSeqLength(A: IntArray): Int {
        val size = A.size
        val reverse = mutableMapOf<Int, MutableList<Int>>()
        for ((i, v) in A.withIndex()) {
            if (v !in reverse) reverse[v] = mutableListOf(i)
            else reverse[v]!!.add(i)
        }

        val cache = mutableMapOf<Int, Int>()
        var max = 2
        for (i in 0 until size) {
            for (j in i+1 until size) {
                val small = A[i]
                val big = A[j]
                val p = small * 2 - big

                if (p in reverse && reverse[p]!![0] < i) {
                    val idx = reverse[p]!!.binarySearch(i).let { if (it < 0) -it - 2 else it-1 }
                    val t = cache[reverse[p]!![idx] * size + i]!! + 1
                    cache[i * size + j] = t
                    if (t > max) max = t
                } else {
                    cache[i * size + j] = 2
                }
            }
        }

        return max
    }
}

fun main() {
    println(Solution1027().longestArithSeqLength(intArrayOf(22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,23,37,53,27,1,47,42,28,31,10,35,39,12,15,6,35,31,45,21,30,19,5,5,4,18,38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52)))
}