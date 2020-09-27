package com.ypwang.hard

class Solution1601 {
    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
        fun helper(idx: Int, taken: Int, degree: IntArray): Int {
            if (idx == requests.size)
                return if (degree.all { it == 0 }) taken else 0

            val (from, to) = requests[idx]
            degree[from]--
            degree[to]++
            val take = helper(idx+1, taken+1, degree)
            degree[from]++
            degree[to]--

            return maxOf(take, helper(idx+1, taken, degree))
        }

        return helper(0, 0, IntArray(n))
    }
}