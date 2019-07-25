package com.ypwang.hard

class Solution99 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun recoverTree(root: TreeNode?) {
        var l: TreeNode? = null
        fun left(t: TreeNode?): TreeNode? {
            if (t == null) return null
            left(t.left)?.let { return it }
            if (l != null && l!!.`val` > t.`val`) return l else l = t
            left(t.right)?.let { return it }
            return null
        }
        left(root)

        var r: TreeNode? = null
        fun right(t: TreeNode?): TreeNode? {
            if (t == null) return null
            right(t.right)?.let { return it }
            if (r != null && r!!.`val` < t.`val`) return t else r = t
            right(t.left)?.let { return it }
            return null
        }
        right(root)

        assert(l != null)
        assert(r != null)
        val t = l!!.`val`
        l!!.`val` = r!!.`val`
        r!!.`val` = t
    }
}

fun main() {
    val root = Solution99.TreeNode(3)
    root.left = Solution99.TreeNode(1)
    root.right = Solution99.TreeNode(4)
    root.right!!.left = Solution99.TreeNode(2)
    Solution99().recoverTree(root)
}