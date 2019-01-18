
package com.ypwang.easy

import com.ypwang.TreeNode

class Solution669 {
    fun trimBST(root: TreeNode?, L: Int, R: Int): TreeNode? {
        return when {
            root == null -> null
            root.`val` > R -> trimBST(root.left, L, R)
            root.`val` < L -> trimBST(root.right, L, R)
            else -> {// cut left & right
                root.left = trimBST(root.left, L, R)
                root.right = trimBST(root.right, L, R)
                root
            }
        }
    }
}

fun main(args: Array<String>) {
    println(Solution669().trimBST(null, 1, 2))
}