package com.ypwang.easy

class Solution997 {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val trustMe = IntArray(N)
        val trustOther = IntArray(N)

        for (t in trust) {
            trustOther[t[0]-1]++
            trustMe[t[1]-1]++
        }

        return (1..N).singleOrNull { trustOther[it-1] == 0 && trustMe[it-1] == N-1 } ?: -1
    }
}

fun main() {
    println(Solution997().findJudge(2, arrayOf()))
}