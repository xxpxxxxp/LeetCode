package com.ypwang.easy

import com.ypwang.TreeNode

class Solution572 {
    fun comparetree(s: TreeNode?, t: TreeNode?): Boolean {
        if (t == null) {
            return s == null
        }
        if (s == null) {
            return false
        }
        return s.`val` == t.`val` && comparetree(s.left, t.left) && comparetree(s.right, t.right)
    }

    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        if (s == null) {
            return t == null
        }

        if (comparetree(s, t)) {
            return true
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t)
    }
}