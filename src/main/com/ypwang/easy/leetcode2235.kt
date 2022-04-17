package com.ypwang.easy

import com.ypwang.TreeNode

class Solution2235 {
    fun checkTree(root: TreeNode?): Boolean = root!!.`val` == (root.left!!.`val` + root.right!!.`val`)
}