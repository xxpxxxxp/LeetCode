package com.ypwang.hard

class Solution3327 {
    fun findAnswer(parent: IntArray, s: String): BooleanArray {
        val child = Array(parent.size) { mutableListOf<Int>() }
        for ((i, v) in parent.withIndex()) {
            if (i == 0)
                continue
            child[v].add(i)
        }

        val rst = BooleanArray(parent.size)
        fun dfs(i: Int): String {
            val r = StringBuilder()

            for (j in child[i].sorted())
                r.append(dfs(j))

            r.append(s[i])
            val t = r.toString()
            if (t == t.reversed())
                rst[i] = true

            return t
        }

        dfs(0)
        return rst
    }
}
