package com.ypwang.medium

class Solution1053 {
    fun prevPermOpt1(A: IntArray): IntArray {
        val cache = mutableListOf<Int>()

        for (i in A.lastIndex downTo 0) {
            if (cache.isEmpty() || A[cache.last()] >= A[i]) cache.add(i)
            else {
                var t = cache[cache.binarySearch { A[i] - A[it] }.let { if (it < 0) -it-1 else it+1 }]
                while (t-1 >= 0 && A[t-1] == A[t]) t--

                val v = A[t]
                A[t] = A[i]
                A[i] = v

                break
            }
        }

        return A
    }
}

fun main() {
    println(Solution1053().prevPermOpt1(intArrayOf(3,1,1,3)).toList())
}