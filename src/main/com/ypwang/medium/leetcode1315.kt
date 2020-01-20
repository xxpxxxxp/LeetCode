package com.ypwang.medium

class Solution1315 {
    fun sumEvenGrandparent(root: TreeNode?): Int {
        var rst = 0

        fun recursive(t: TreeNode?, grandParent: Boolean, parent: Boolean) {
            if (t == null) return
            if (grandParent) rst += t.`val`
            val c = t.`val` % 2 == 0
            recursive(t.left, parent, c)
            recursive(t.right, parent, c)
        }

        recursive(root, false, false)
        return rst
    }
}