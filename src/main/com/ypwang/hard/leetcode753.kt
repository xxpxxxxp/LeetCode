package com.ypwang.hard

class Solution753 {
    fun crackSafe(n: Int, k: Int): String {
        if (n == 1 && k == 1) return "0"
        val seen = mutableSetOf<String>()
        val ans = StringBuilder()

        fun dfs(node: String, k: Int) {
            for (x in 0 until k) {
                val nei = node + x
                if (!seen.contains(nei)) {
                    seen.add(nei)
                    dfs(nei.substring(1), k)
                    ans.append(x)
                }
            }
        }

        val start = CharArray(n-1){ '0' }.joinToString("")
        dfs(start, k)
        ans.append(start)
        return ans.toString()
    }
}