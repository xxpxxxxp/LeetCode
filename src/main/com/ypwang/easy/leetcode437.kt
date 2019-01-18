package com.ypwang.easy

import com.ypwang.TreeNode

class Solution437 {
    fun helper(root: TreeNode?, sum: Int, fathersum: Int, fathers: MutableMap<Int, Int>): Int {
        if (root == null) {
            return 0
        }
        val cursum = root.`val` + fathersum
        var all = fathers.getOrDefault(cursum-sum, 0)
        fathers[cursum] = fathers.getOrDefault(cursum, 0) + 1
        all += helper(root.left, sum, cursum, fathers)
        all += helper(root.right, sum, cursum, fathers)
        fathers[cursum] = fathers[cursum]!! - 1
        if (fathers[cursum] == 0) {
            fathers.remove(cursum)
        }
        return all
    }

    fun pathSum(root: TreeNode?, sum: Int): Int {
        return helper(root, sum, 0, mutableMapOf(0 to 1))
    }
}

fun main(args: Array<String>) {
    val root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(1)
    println(Solution437().pathSum(root, 1))
}