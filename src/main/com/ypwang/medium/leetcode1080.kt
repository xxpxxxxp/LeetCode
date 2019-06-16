package com.ypwang.medium

class Solution1080 {
    private fun helper(sum: Int, cur: TreeNode, limit: Int): Boolean {
        if (cur.left == null && cur.right == null) return sum + cur.`val` < limit

        val left = cur.left?.let { helper(sum + cur.`val`, it, limit) } ?: true
        if (left) {
            cur.left = null
        }
        val right = cur.right?.let { helper(sum + cur.`val`, it, limit) } ?: true
        if (right) {
            cur.right = null
        }
        return left && right
    }

    fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
        val r = TreeNode(0)
        r.left = root

        helper(0, r, limit)
        return r.left
    }
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.left!!.left = TreeNode(11)
    root.left!!.left!!.left = TreeNode(7)
    root.left!!.left!!.right = TreeNode(1)
    root.right = TreeNode(8)
    root.right!!.left = TreeNode(17)
    root.right!!.right = TreeNode(4)
    root.right!!.right!!.left = TreeNode(5)
    root.right!!.right!!.right = TreeNode(3)

    println(Solution1080().sufficientSubset(root, 22))
}