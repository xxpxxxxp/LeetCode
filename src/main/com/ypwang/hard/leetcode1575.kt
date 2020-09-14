package com.ypwang.hard

class Solution1575 {
    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        val dp = Array(locations.size){ IntArray(fuel+1){-1} }

        fun search(idx: Int, f: Int): Int {
            if (dp[idx][f] == -1) {
                var rst = 0

                if (idx == start)
                    rst++

                for ((i, loc) in locations.withIndex()) {
                    if (i != idx) {
                        val len = Math.abs(locations[idx] - loc)
                        if (len <= f) {
                            rst = (rst + search(i, f - len)) % 1000000007
                        }
                    }
                }

                dp[idx][f] = rst
            }

            return dp[idx][f]
        }

        return search(finish, fuel)
    }
}