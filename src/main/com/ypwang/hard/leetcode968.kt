package com.ypwang.hard

import com.ypwang.TreeNode

class Solution968 {
    fun minCameraCover(root: TreeNode?): Int {
        var ans = 0
        val covered = mutableSetOf<TreeNode?>(null)

        fun dfs(cur: TreeNode?, parent: TreeNode?) {
            if (cur == null) return
            dfs(cur.left, cur)
            dfs(cur.right, cur)

            if ((parent == null && cur !in covered) || cur.left !in covered || cur.right !in covered) {
                ans++
                covered.add(cur)
                covered.add(cur.left)
                covered.add(cur.right)
                covered.add(parent)
            }
        }

        dfs(root, null)
        return ans
    }
}