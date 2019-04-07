package com.ypwang.medium

import com.ypwang.TreeNode

class Solution450 {
    private fun maxOfLeft(father: TreeNode?, cur: TreeNode?): TreeNode? {
        if (cur == null) return null
        if (cur.right == null) {
            if (father != null)
                father.right = cur.left
            return cur
        }
        return maxOfLeft(cur, cur.right)
    }

    private fun minOfRight(father: TreeNode?, cur: TreeNode?): TreeNode? {
        if (cur == null) return null
        if (cur.left == null) {
            if (father != null)
                father.left = cur.right
            return cur
        }
        return maxOfLeft(cur, cur.left)
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        return when {
            root == null -> null
            root.`val` == key -> {
                val left = maxOfLeft(null, root.left)
                if (left != null) {
                    if (left.`val` != root.left!!.`val`)
                        left.left = root.left
                    left.right = root.right
                    return left
                }

                val right = minOfRight(null, root.right)
                if (right != null) {
                    right.left = root.left
                    if (right.`val` != root.right!!.`val`)
                        right.right = root.right
                    return right
                }
                return null
            }
            root.`val` > key -> {
                root.left = deleteNode(root.left, key)
                return root
            }
            else -> {
                root.right = deleteNode(root.right, key)
                return root
            }
        }
    }
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.left!!.left = TreeNode(2)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(6)
    root.right!!.right = TreeNode(7)

    //val a = Solution450().deleteNode(root,3)
    val b = Solution450().deleteNode(root,6)
    val c = Solution450().deleteNode(b,5)
}