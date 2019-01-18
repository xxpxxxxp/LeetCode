package com.ypwang.easy

import com.ypwang.TreeNode

class Solution257 {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val rst = mutableListOf<String>()
        if (root == null) {
            return rst
        }

        val queue = mutableListOf(Pair(root, root.`val`.toString()))

        while (!queue.isEmpty()) {
            val first = queue.first()
            queue.removeAt(0)

            val node = first.first
            if (node.left == null && node.right == null) {
                rst.add(first.second)
            }

            node.left?.let { queue.add(Pair(it, first.second + "->" + it.`val`.toString())) }
            node.right?.let { queue.add(Pair(it, first.second + "->" + it.`val`.toString())) }
        }

        return rst
    }
}