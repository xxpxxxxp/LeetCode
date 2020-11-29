package com.ypwang.medium

class Solution969 {
    fun pancakeSort(A: IntArray): List<Int> {
        val ans = mutableListOf<Int>()
        var n = A.size

        val B = A.withIndex().sortedByDescending { it.value }.map { it.index + 1 }

        for (i in B) {
            var j = i
            for (f in ans)
                if (j <= f)
                    j = f + 1 - j

            if (j != n) {
                ans.add(j)
                ans.add(n)
            }
            n -= 1
        }

        return ans
    }
}

fun main() {
    println(Solution969().pancakeSort(intArrayOf(3,2,4,1)))
}