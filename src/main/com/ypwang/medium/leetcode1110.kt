package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution1110 {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        if (root == null) return listOf()

        val delete = to_delete.toSet()
        val rst = mutableListOf<TreeNode?>()
        val queue = LinkedList<Pair<TreeNode, Boolean>>()

        queue.add(root to true)

        while (queue.isNotEmpty()) {
            val t = queue.poll()
            val r = t.first
            var orphan = r.`val` in delete
            r.left?.let {
                queue.add(it to orphan)
                if (it.`val` in delete) r.left = null
            }
            r.right?.let {
                queue.add(it to orphan)
                if (it.`val` in delete) r.right = null
            }

            if (t.second && !orphan) rst.add(t.first)
        }

        return rst
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(3)

    println(Solution1110().delNodes(root, intArrayOf(2,3)))
}