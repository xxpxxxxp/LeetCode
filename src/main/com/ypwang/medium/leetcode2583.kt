package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution2583 {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        val list = mutableListOf<Long>()
        val qu: Queue<TreeNode> = LinkedList()
        qu.offer(root)
        while (qu.isNotEmpty()) {
            val p = qu.size
            var s = 0L
            for (i in 0 until p) {
                val node = qu.poll()
                if (node.left != null)
                    qu.offer(node.left)
                if (node.right != null)
                    qu.offer(node.right)

                s += node.`val`
            }
            list.add(s)
        }
        list.sortDescending()
        return if (k > list.size) -1 else list[k-1]
    }
}