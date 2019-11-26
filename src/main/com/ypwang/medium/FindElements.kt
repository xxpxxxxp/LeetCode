package com.ypwang.medium

import com.ypwang.TreeNode
import java.util.*

class FindElements(val root: TreeNode?) {
    fun find(target: Int): Boolean {
        val rst = Stack<Boolean>()
        var t = target
        while (t != 0) {
            rst.push(t % 2 == 1)
            t = (t - 1) / 2
        }

        var r = root
        while (rst.isNotEmpty() && r != null) {
            r = if (rst.pop()) r.left else r.right
        }

        return r != null && rst.isEmpty()
    }
}

fun main() {
    val r1 = TreeNode(-1)
    r1.right = TreeNode(-1)
    println(FindElements(r1).find(1))
    println(FindElements(r1).find(2))

    val r2 = TreeNode(-1)
    r2.left = TreeNode(-1)
    r2.right = TreeNode(-1)
    r2.left!!.left = TreeNode(-1)
    r2.left!!.right = TreeNode(-1)
    println(FindElements(r2).find(1))
    println(FindElements(r2).find(3))
    println(FindElements(r2).find(5))
}