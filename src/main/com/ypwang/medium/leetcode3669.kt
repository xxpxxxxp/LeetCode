package com.ypwang.medium

class Solution3669 {
    private fun solve(
        n: Int,
        d: Int,
        k: Int,
        curr: MutableList<Int>,
        ans: MutableList<Int>,
        mini: IntArray // using array as mutable reference for mini
    ) {
        if (d == k - 1) {
            if (n >= 1) {
                curr.add(n)
                val m = curr.max() - curr.min()
                if (m < mini[0]) {
                    mini[0] = m
                    ans.clear()
                    ans.addAll(curr)
                }
                curr.removeAt(curr.size - 1)
            }
            return
        }

        var i = 1
        while (i * i <= n) {
            if (n % i == 0) {
                curr.add(i)
                solve(n / i, d + 1, k, curr, ans, mini)
                curr.removeAt(curr.size - 1)

                if (i != n / i) {
                    curr.add(n / i)
                    solve(i, d + 1, k, curr, ans, mini)
                    curr.removeAt(curr.size - 1)
                }
            }
            i++
        }
    }

    fun minDifference(n: Int, k: Int): IntArray {
        val ans = mutableListOf<Int>()
        val mini = intArrayOf(Int.MAX_VALUE)
        val curr = mutableListOf<Int>()
        solve(n, 0, k, curr, ans, mini)
        return ans.toIntArray()
    }
}

fun main() {
    println(Solution3669().minDifference(100, 2).toList())
}