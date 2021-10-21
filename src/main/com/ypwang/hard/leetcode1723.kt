package com.ypwang.hard

class Solution1723 {
    fun minimumTimeRequired(jobs: IntArray, k: Int): Int {
        if (jobs.size == k)
            return jobs.maxOrNull()!!

        jobs.sortDescending()

        val cap = (jobs.indices step k).sumBy { jobs[it] }
        val workers = IntArray(k)

        fun dfs(i: Int, cur: Int): Int{
            if (cur >= cap)
                return cap

            if (i == jobs.size)
                return cur

            var rst = Int.MAX_VALUE
            val visited = mutableSetOf<Int>()
            for (j in 0 until k) {
                if (workers[j] !in visited) {
                    visited.add(workers[j])
                    workers[j] += jobs[i]
                    rst = minOf(rst, dfs(i+1, maxOf(cur, workers[j])))
                    workers[j] -= jobs[i]
                }
            }

            return rst
        }

        return dfs(0, 0)
    }
}

fun main() {
    println(Solution1723().minimumTimeRequired(intArrayOf(46,13,54,51,38,49,54,67,26,78,33), 10))
}