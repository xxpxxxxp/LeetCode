package com.ypwang.hard

import java.util.*

class Solution761 {
    class Tree {
        val sub: MutableList<Tree> = mutableListOf()
    }

    fun makeLargestSpecial(S: String): String {
        fun mkStr(root: Tree): String =
                if (root.sub.isEmpty()) "10"
                else "1${root.sub.map { mkStr(it) }.sortedDescending().joinToString("")}0"

        val root = Tree()
        val stack = Stack<Tree>()
        stack.add(root)

        for ((i, c) in S.withIndex()) {
            when (c) {
                '1' -> {
                    val cur = Tree()
                    stack.peek().sub.add(cur)
                    stack.add(cur)
                }
                '0' -> {
                    stack.pop()
                }
            }
        }

        return mkStr(root).let { it.substring(1, it.lastIndex) }
    }
}

fun main() {
    println(Solution761().makeLargestSpecial("11011000"))
}
