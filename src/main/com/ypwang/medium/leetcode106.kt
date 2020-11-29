package com.ypwang.medium

import com.ypwang.TreeNode

class Solution106 {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty())
            return null

        fun buildTree(inBegin: Int, inEnd: Int, postBegin: Int, postEnd: Int): TreeNode? {
            if (inBegin >= inEnd)
                return null

            val rootValue = postorder[postEnd - 1]
            val root = TreeNode(rootValue)

            val inorderIndex = (inBegin until inEnd).indexOfFirst { inorder[it] == rootValue } + inBegin

            root.left = buildTree(inBegin, inorderIndex, postBegin, postBegin + inorderIndex - inBegin)
            root.right = buildTree(inorderIndex + 1, inEnd, postBegin + inorderIndex - inBegin, postEnd - 1)
            return root
        }

        return buildTree(0, inorder.size, 0, postorder.size)
    }
}

fun main() {
    println(Solution106().buildTree(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3)))
}