package com.ypwang.medium

import java.util.*

class Solution1305 {
    class TreeIterator(root: TreeNode): Iterator<Int> {
        data class Element(val n: TreeNode, var leftVisited: Boolean = false)

        private val stack = Stack<Element>()

        init {
            stack.add(Element(root))
        }

        override fun hasNext(): Boolean {
            if (stack.isEmpty()) return false

            while (!stack.peek().leftVisited && stack.peek().n.left != null) {
                stack.peek().leftVisited = true
                stack.push(Element(stack.peek().n.left!!))
            }

            return true
        }

        override fun next(): Int {
            return stack.pop().let {
                if (it.n.right != null) stack.push(Element(it.n.right!!))
                it.n.`val`
            }
        }

        fun peek(): Int = stack.peek().n.`val`
    }

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        if (root1 == null && root2 == null) return listOf()
        if (root1 == null) return TreeIterator(root2!!).asSequence().toList()
        if (root2 == null) return TreeIterator(root1!!).asSequence().toList()

        val t1 = TreeIterator(root1)
        val t2 = TreeIterator(root2)

        val rst = mutableListOf<Int>()
        while (t1.hasNext() && t2.hasNext()) {
            val v1 = t1.peek()
            val v2 = t2.peek()
            rst.add(if (v1 < v2) t1.next() else t2.next())
        }

        while (t1.hasNext()) rst.add(t1.next())
        while (t2.hasNext()) rst.add(t2.next())

        return rst
    }
}

fun main() {
    val root1 = TreeNode(2)
    root1.left = TreeNode(1)
    root1.right = TreeNode(4)
    val root2 = TreeNode(1)
    root2.left = TreeNode(0)
    root2.right = TreeNode(3)
    println(Solution1305().getAllElements(root1, root2))
}