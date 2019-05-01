package com.ypwang.medium

class Solution955 {
    fun minDeletionSize(A: Array<String>): Int {
        var intervals = listOf(0 to A.lastIndex)
        var rst = 0

        label@ for (i in 0 until A[0].length) {
            val ins = mutableListOf<Pair<Int, Int>>()
            for (interval in intervals) {
                // check if interval is all sorted
                if ((interval.first until interval.second).any { A[it][i] > A[it+1][i] }) {
                    // no it's not, remove current i
                    rst += 1
                    continue@label
                }

                // let's break interval
                var cur = interval.first
                for (j in interval.first + 1 .. interval.second) {
                    if (A[cur][i] != A[j][i]) {
                        if (cur+1 != j) ins.add(cur to j-1)
                        cur = j
                    }
                }
                if (cur != interval.second) ins.add(cur to interval.second)
            }
            intervals = ins
        }

        return rst
    }
}

fun main() {
    println(Solution955().minDeletionSize(arrayOf("abx","agz","bgc","bfc")))
}