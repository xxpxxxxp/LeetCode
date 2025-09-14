package com.ypwang.medium

class Solution3680 {
    fun generateSchedule(n: Int): Array<IntArray> {
        val ans = mutableListOf<IntArray>()

        // Impossible when n <= 4
        if (n <= 4)
            return ans.toTypedArray()

        // [0,1],[2,3],...,[1,2],[3,4],...
        var taken = BooleanArray(n)
        var first = 0
        var used = 0
        while (used < n) {
            if (taken[first]) {
                first = (first + 1) % n
            } else {
                taken[first] = true
                ans.add(intArrayOf(first, (first + 1) % n))
                used++
                first = (first + 2) % n
            }
        }

        // [1,0],[3,2],...,[2,1],[4,3],...
        taken = BooleanArray(n)
        used = 0
        while (used < n) {
            if (taken[first]) {
                first = (first + 1) % n
            } else {
                taken[first] = true
                ans.add(intArrayOf((first + 1) % n, first))
                used++
                first = (first + 2) % n
            }
        }

        // [0,d],[1,d+1],...,[n−1,n−1+d]
        for (d in 2 until n - 1) {
            // Shift order if needed
            while (first in ans.last() || (first + d) % n in ans.last()) {
                first = (first + 1) % n
            }
            repeat(n) {
                ans.add(intArrayOf(first, (first + d) % n))
                first = (first + 1) % n
            }
        }

        return ans.toTypedArray()
    }
}
