package com.ypwang.easy

import com.ypwang.TreeNode

class Solution671 {
    fun helper(root: TreeNode, target: Int, min :Int): Int {
        if (root.`val` > min) {
            // skip branch
            return min
        }
        var mymin = min
        if (root.`val` > target) {
            mymin = root.`val`
        }
        if (root.left != null) {
            mymin = helper(root.left!!, target, mymin)
        }
        if (root.right != null) {
            mymin = helper(root.right!!, target, mymin)
        }

        return mymin
    }

    fun findSecondMinimumValue(root: TreeNode?): Int {
        if (root == null) {
            return -1
        }
        val min = helper(root, root.`val`, Int.MAX_VALUE)
        return if (min == Int.MAX_VALUE) -1 else min
    }
}