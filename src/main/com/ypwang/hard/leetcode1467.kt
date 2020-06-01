package com.ypwang.hard

class Solution1467 {
    private fun perm(A: IntArray): Double {
        var ans = 1.0
        var j = 1
        for (i in A.indices) {
            val n = A[i]
            for (k in 1..n) {
                ans = ans * j / k
                j++
            }
        }
        return ans
    }

    private fun dfs(balls: IntArray, sum: Int, a: IntArray, b: IntArray, i: Int, sa: Int, sb: Int): Double {
        if (sa > sum || sb > sum) return 0.0
        if (i == balls.size) {
            return if (a.count { it > 0 } != b.count { it > 0 }) 0.0
            else perm(a) * perm(b)
        }

        val ans = (0..balls[i]).sumByDouble {
            a[i] = it
            b[i] = balls[i] - it
            dfs(balls, sum, a, b, i+1, sa+a[i],sb+b[i])
        }

        a[i] = 0
        b[i] = 0
        return ans
    }

    fun getProbability(balls: IntArray): Double {
        val sum = balls.sum() / 2
        return dfs(balls, sum, IntArray(balls.size), IntArray(balls.size), 0, 0, 0) / perm(balls)
    }
}

fun main() {
    println(Solution1467().getProbability(intArrayOf(1,1)))
    println(Solution1467().getProbability(intArrayOf(2,1,1)))
    println(Solution1467().getProbability(intArrayOf(1,2,1,2)))
    println(Solution1467().getProbability(intArrayOf(3,2,1)))
    println(Solution1467().getProbability(intArrayOf(6,6,6,6,6,6)))
}