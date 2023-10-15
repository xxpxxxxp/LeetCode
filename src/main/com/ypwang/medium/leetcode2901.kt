package com.ypwang.medium

class Solution2901 {
    fun getWordsInLongestSubsequence(n: Int, words: Array<String>, groups: IntArray): List<String> {
        val dp = IntArray(n) { 1 }
        val pre = IntArray(n) { -1 }

        for (i in 1 until groups.size) {
            for (j in 0 until i) {
                if (groups[i] == groups[j] || words[i].length != words[j].length || words[i].zip(words[j]).count { it.first != it.second } != 1)
                    continue  // If the groups are the same, skip.

                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1
                    pre[i] = j
                }
            }
        }

        val max = dp.max()!!
        var idx = dp.indexOf(max)
        val rst = mutableListOf<String>()
        while (idx != -1) {
            rst.add(words[idx])
            idx = pre[idx]
        }
        return rst.reversed()
    }
}