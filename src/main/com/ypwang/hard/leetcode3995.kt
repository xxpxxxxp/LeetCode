package com.ypwang.hard

class Solution3995 {
    fun minCost(source: String, target: String, rules: List<List<String>>, costs: IntArray): Int {
        val n = source.length
        val dp = IntArray(n + 1) { -1 }
        dp[0] = 0

        for (i in 1..n) {
            if (dp[i - 1] != -1 && source[i - 1] == target[i - 1])
                dp[i] = dp[i - 1]

            for (k in rules.indices) {
                val (pattern, replacement) = rules[k]
                val len = pattern.length

                if (i - len >= 0 && dp[i - len] != -1) {
                    var match = true
                    var wildcards = 0

                    for (j in 0 until len) {
                        if (pattern[j] == '*')
                            wildcards++
                        else if (pattern[j] != source[i - len + j]) {
                            match = false
                            break
                        }

                        if (replacement[j] != target[i - len + j]) {
                            match = false
                            break
                        }
                    }

                    if (match) {
                        val totalRuleCost = costs[k] + wildcards
                        val currentCost = dp[i - len] + totalRuleCost

                        if (dp[i] == -1 || currentCost < dp[i])
                            dp[i] = currentCost
                    }
                }
            }
        }

        return dp[n]
    }
}
