package com.ypwang.medium

import com.ypwang.TreeNode

class Solution1530 {
    fun countPairs(root: TreeNode?, distance: Int): Int {
        fun dfs(node: TreeNode): Pair<Int, IntArray> {
            if (node.left == null && node.right == null)
                return 0 to IntArray(9).apply { this[0] = 1 }

            val (c1, left) = node.left?.let { dfs(it) }?: (0 to IntArray(9))
            val (c2, right) = node.right?.let { dfs(it) }?: (0 to IntArray(9))

            var count = c1 + c2
            val merged = IntArray(9)

            for (i in 0 until 9) {
                if (i > 0)
                    merged[i] = left[i-1] + right[i-1]

                for (j in 0 until 9) {
                    if (i + j + 2 <= distance)
                        count += left[i] * right[j]
                }
            }

            return count to merged
        }

        return dfs(root!!).first
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(3)
    println(Solution1530().countPairs(root, 3))
}