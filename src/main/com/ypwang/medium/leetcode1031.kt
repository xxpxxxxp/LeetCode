package com.ypwang.medium

import java.util.*

class Solution1031 {
    fun maxSumTwoNoOverlap(A: IntArray, L: Int, M: Int): Int {
        val stack = Stack<Pair<Int, Int>>()
        var sum = A.takeLast(L).sum()
        stack.push(A.size - L to sum)

        for (i in A.lastIndex - L downTo M) {
            sum += A[i] - A[i + L]
            if (sum > stack.peek().second)
                stack.add(i to sum)
        }

        var leftMax = 0
        var lwindow = 0
        sum = A.take(M).sum()
        var totalMax = sum + stack.peek().second
        for (i in M until A.size) {
            if (stack.isNotEmpty() && i == stack.peek().first)
                stack.pop()

            sum += A[i] - A[i-M]
            lwindow += A[i-M]

            var lmax = if (stack.isEmpty()) 0 else stack.peek().second
            if (i >= M + L - 1) {
                if (i >= M + L) lwindow -= A[i-M-L]
                if (lwindow > leftMax) leftMax = lwindow
            }
            lmax = maxOf(lmax, leftMax)
            if (lmax + sum > totalMax) totalMax = lmax + sum
        }

        return totalMax
    }
}

fun main() {
    println(Solution1031().maxSumTwoNoOverlap(intArrayOf(8,20,6,2,20,17,6,3,20,8,12), 5, 4))
}