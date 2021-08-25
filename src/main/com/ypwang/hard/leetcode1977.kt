package com.ypwang.hard

class Solution1977 {
    fun numberOfCombinations(num: String): Int {
        val dp = Array(num.length) { IntArray(num.length) { -1 } }

        fun isLarger(a: Collection<Char>, b: Collection<Char>): Boolean {
            if (a.size < b.size)
                return true

            if (a.size > b.size)
                return false

            for ((x, y) in a.zip(b)) {
                if (x < y)
                    return true
                if (x > y)
                    return false
            }

            return true
        }

        fun helper(len: Int, idx: Int): Int {
            if (idx == num.length)
                return 1

            if (dp[len][idx] == -1)
                dp[len][idx] =
                    if (num[idx] == '0')
                        // leading 0 not allowed
                        0
                    else {
                        val pre = num.substring(idx-len, idx).toList()
                        var rst = 0
                        var larger = pre.isEmpty()
                        val sb = mutableListOf<Char>()

                        for (id in idx until num.length) {
                            sb.add(num[id])
                            if (larger || isLarger(pre, sb)) {
                                larger = true
                                rst = (rst + helper(id + 1 - idx, id + 1)) % 1000000007
                            }
                        }

                        rst
                    }

            return dp[len][idx]
        }

        return helper(0, 0)
    }
}

fun main() {
    println(Solution1977().numberOfCombinations("24896"))
    println(Solution1977().numberOfCombinations("9999999999999"))
    println(Solution1977().numberOfCombinations("327"))
    println(Solution1977().numberOfCombinations("094"))
    println(Solution1977().numberOfCombinations("0"))
}