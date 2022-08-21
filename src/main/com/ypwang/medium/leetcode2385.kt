package com.ypwang.medium

import com.ypwang.TreeNode

class Solution2385 {
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        val conn = mutableMapOf<Int, MutableList<Int>>()

        fun dfs(r: TreeNode) {
            if (r.left != null) {
                conn.getOrPut(r.`val`) { mutableListOf() }.add(r.left.`val`)
                conn.getOrPut(r.left.`val`) { mutableListOf() }.add(r.`val`)
                dfs(r.left)
            }

            if (r.right != null) {
                conn.getOrPut(r.`val`) { mutableListOf() }.add(r.right.`val`)
                conn.getOrPut(r.right.`val`) { mutableListOf() }.add(r.`val`)
                dfs(r.right)
            }
        }

        dfs(root!!)

        var c = -1
        val seen = mutableSetOf<Int>()
        var cur: List<Int> = mutableListOf(start)

        while (cur.isNotEmpty()) {
            val next = mutableListOf<Int>()
            seen.addAll(cur)

            for (n in cur) {
                for (nn in conn.getOrDefault(n, mutableListOf())) {
                    if (nn !in seen) {
                        next.add(nn)
                    }
                }
            }

            cur = next
            c++
        }

        return c
    }
}