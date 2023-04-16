package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution2641 {
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        root!!.`val` = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val n = queue.size
            val buf = mutableListOf<TreeNode>()
            var sum = 0
            for (i in 0 until n) {
                val node = queue.poll()
                buf.add(node)
                node.left?.let {
                    queue.offer(it)
                    sum += it.`val`
                }
                node.right?.let {
                    queue.offer(it)
                    sum += it.`val`
                }
            }

            for (node in buf) {
                var t = sum
                node.left?.let { t -= it.`val` }
                node.right?.let { t -= it.`val` }
                node.left?.run { this.`val` = t }
                node.right?.run { this.`val` = t }
            }
        }

        return root
    }
}