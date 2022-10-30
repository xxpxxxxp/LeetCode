package com.ypwang.hard

import com.ypwang.TreeNode

class Solution2458 {
    fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
        val level = mutableMapOf<Int, MutableList<Int>>()
        val node = mutableMapOf<Int, Pair<Int, Int>>()

        fun dfs(n: TreeNode?, l: Int): Int {
            if (n == null)
                return 0

            val left = dfs(n.left, l+1)
            val right = dfs(n.right, l+1)

            val curDepth = maxOf(left, right) + 1
            level.getOrPut(l) { mutableListOf() }.add(curDepth)
            node[n.`val`] = l to curDepth
            return curDepth
        }

        dfs(root, 0)
        level.forEach { it.value.sortDescending() }

        return queries.map {
            val (l, d) = node[it]!!
            val ds = level[l]!!
            l - 1 + if (d != ds.first())
                ds.first()
            else {
                if (ds.size > 1)
                    ds[1]
                else 0
            }
        }.toIntArray()
    }
}

fun main() {
    val r = TreeNode(5)
    r.left = TreeNode(8)
    r.left!!.left = TreeNode(2)
    r.left!!.left!!.left = TreeNode(4)
    r.left!!.left!!.right = TreeNode(6)
    r.left!!.right = TreeNode(1)
    r.right = TreeNode(9)
    r.right.left = TreeNode(3)
    r.right.right = TreeNode(7)

    println(Solution2458().treeQueries(r, intArrayOf(3,2,4,8)).toList())
}