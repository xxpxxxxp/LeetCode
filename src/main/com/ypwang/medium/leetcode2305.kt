package com.ypwang.medium

class Solution2305 {
    fun distributeCookies(cookies: IntArray, k: Int): Int {
        fun dfs(cookies: IntArray, cur: Int, k: Int, children: IntArray): Int {
            if (cur == cookies.size)
                return children.maxOrNull()!!

            var rst = Int.MAX_VALUE
            for (i in 0 until k) {
                children[i] += cookies[cur]
                rst = minOf(rst, dfs(cookies, cur + 1, k, children))
                children[i] -= cookies[cur]
            }
            return rst
        }

        return dfs(cookies, 0, k, IntArray(k))
    }
}