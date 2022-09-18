package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class Solution2415 {
    fun reverseOddLevels(root: TreeNode): TreeNode? {
        var level = -1
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        while (q.isNotEmpty()) {
            ++level
            val size = q.size
            val arr = arrayOfNulls<TreeNode>(size)
            for (i in 0 until size) {
                val curr = q.poll()
                if (curr.left != null)
                    q.add(curr.left)
                if (curr.right != null)
                    q.add(curr.right)
                arr[i] = curr
            }
            if (level % 2 != 0)
                reverse(arr)
        }
        return root
    }

    fun reverse(arr: Array<TreeNode?>) {
        var i = 0
        var j = arr.size - 1
        while (i < j) {
            val temp = arr[i]!!.`val`
            arr[i]!!.`val` = arr[j]!!.`val`
            arr[j]!!.`val` = temp
            i++
            j--
        }
    }
}