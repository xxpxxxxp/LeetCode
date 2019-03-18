package com.ypwang.medium

import com.ypwang.TreeNode

class Solution105 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty())
            return null

        fun buildTree(preBegin: Int, preEnd: Int, inBegin: Int, inEnd: Int): TreeNode? {
            if (preBegin >= preEnd)
                return null

            val rootValue = preorder[preBegin]
            val root = TreeNode(rootValue)

            val inorderIndex = (inBegin until inEnd).indexOfFirst { inorder[it] == rootValue } + inBegin

            root.left = buildTree(preBegin + 1, preBegin + inorderIndex - inBegin + 1, inBegin, inorderIndex)
            root.right = buildTree(preBegin + inorderIndex - inBegin + 1, preEnd, inorderIndex + 1, inEnd)
            return root
        }

        return buildTree(0, preorder.size, 0, inorder.size)
    }
}

fun main(args: Array<String>) {
    println(Solution105().buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7)))
}