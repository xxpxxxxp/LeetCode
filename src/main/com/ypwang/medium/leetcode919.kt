package com.ypwang.medium

import com.ypwang.TreeNode

class CBTInserter(val root: TreeNode?) {
    var depth = 0

    init {
        var tmp = root!!
        while (tmp.left != null) {
            depth++
            tmp = tmp.left!!
        }
    }

    private fun helper(v: Int, current: TreeNode, dep: Int): Pair<Boolean, Int> {
        if (dep == depth - 1) {
            if (current.left == null) {
                current.left = TreeNode(v)
                return Pair(true, current.`val`)
            }
            if (current.right == null) {
                current.right = TreeNode(v)
                return Pair(true, current.`val`)
            }
        }


        if (current.left != null) {
            val r = helper(v, current.left!!, dep + 1)
            if (r.first) {
                return r
            }
        }

        if (current.right != null) {
            val r = helper(v, current.right!!, dep + 1)
            if (r.first) {
                return r
            }
        }

        return Pair(false, 0)
    }

    fun insert(v: Int): Int {
        val rst = helper(v, root!!, 0)
        if (rst.first) {
            return rst.second
        } else {
            var tmp = root
            for (i in 0 until depth) {
                tmp = tmp!!.left
            }
            tmp!!.left = TreeNode(v)
            depth++
            return tmp.`val`
        }
    }

    fun get_root(): TreeNode? {
        return root
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)

    val c = CBTInserter(root)
    println(c.insert(7))
    println(c.insert(8))
    println(c.get_root())
}