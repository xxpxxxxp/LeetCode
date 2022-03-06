package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution2196 {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val rootVal = descriptions.map { it[0] }.toSet().subtract(descriptions.map { it[1] }.toSet()).single()!!

        val group = descriptions.groupBy { it[0] }
        val root = TreeNode(rootVal)
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val v = cur.`val`
            for ((_, n, l) in group.getOrDefault(v, mutableListOf())) {
                val node = TreeNode(n)
                if (l == 1)
                    cur.left = node
                else
                    cur.right = node

                queue.add(node)
            }
        }

        return root
    }
}