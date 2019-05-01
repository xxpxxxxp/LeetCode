package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution988 {
    fun smallestFromLeaf(root: TreeNode?): String {
        if (root == null) return ""

        var ans = "~"
        val stack = Stack<Char>()
        fun dfs(cur: TreeNode) {
            stack.push('a' + cur.`val`)

            if (cur.left == null && cur.right == null) {
                val now = stack.joinToString("").reversed()
                if (now < ans) ans = now
            }

            cur.left ?.let { dfs(it) }
            cur.right ?.let { dfs(it) }

            stack.pop()
        }

        dfs(root)
        return ans
    }
}

fun main() {
    val root = TreeNode(25)
    root.left = TreeNode(1)
    root.left!!.right = TreeNode(0)
    root.left!!.left = TreeNode(0)
    root.left!!.left!!.left = TreeNode(1)
    root.left!!.left!!.left!!.left = TreeNode(0)

    println(Solution988().smallestFromLeaf(root))
}