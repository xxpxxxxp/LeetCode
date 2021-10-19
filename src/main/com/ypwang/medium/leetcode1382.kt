package com.ypwang.medium

import com.ypwang.TreeNode

class Solution1382 {
    fun balanceBST(root: TreeNode?): TreeNode? {
        val sorted = mutableListOf<Int>()
        fun inorder(node: TreeNode?) {
            if (node == null) return
            inorder(node.left)
            sorted.add(node.`val`)
            inorder(node.right)
        }

        inorder(root)

        fun toBST(start: Int, end: Int): TreeNode? {
            if (start == end) return null
            val mid = (start + end) / 2
            val node = TreeNode(sorted[mid])
            node.left = toBST(start, mid)
            node.right = toBST(mid+1, end)
            return node
        }

        return toBST(0, sorted.size)
    }
}