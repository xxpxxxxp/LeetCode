package com.ypwang.medium

import com.ypwang.TreeNode

class Solution654 {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }
        var index = 0
        var max = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] > max) {
                index = i
                max = nums[i]
            }
        }

        val root = TreeNode(max)
        root.left = constructMaximumBinaryTree(nums.slice(0 until index).toIntArray())
        root.right = constructMaximumBinaryTree(nums.slice(index+1 until nums.size).toIntArray())
        return root
    }
}