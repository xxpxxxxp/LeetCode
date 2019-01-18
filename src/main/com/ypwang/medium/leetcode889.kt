package com.ypwang.medium

import com.ypwang.TreeNode

class Solution889 {
    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? {
        return constructFromPrePost(pre, 0, pre.size, post, 0, post.size,
                post.mapIndexed { index, value -> value to index }.toMap())
    }

    private fun constructFromPrePost(pre: IntArray, preBegin: Int, preEnd: Int, post: IntArray, postBegin: Int, postEnd: Int,
                                     map: Map<Int, Int>): TreeNode? {
        return when {
            preBegin == preEnd -> null
            preBegin + 1 == preEnd -> TreeNode(pre[preBegin])
            else -> TreeNode(pre[preBegin]).apply {
                val leftNodes = map[pre[preBegin + 1]]!! - postBegin + 1
                this.left = constructFromPrePost(pre, preBegin + 1, preBegin + 1 + leftNodes, post, postBegin, postBegin + leftNodes, map)
                this.right = constructFromPrePost(pre, preBegin + 1 + leftNodes, preEnd, post, postBegin + leftNodes, postEnd - 1, map)
            }
        }
    }
}