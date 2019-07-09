package com.ypwang.hard

import java.util.*

class Solution761 {
    class Tree(val start: Int) {
        var end: Int = 0
        val sub: MutableList<Tree> = mutableListOf()
    }

    fun makeLargestSpecial(S: String): String {
        fun mkStr(root: Tree): String =
                if (root.sub.isEmpty()) S.substring(root.start, root.end)
                else "1${root.sub.map { mkStr(it) }.sortedDescending().joinToString("")}0"

        val root = Tree(0)
        val stack = Stack<Tree>()
        stack.add(root)

        for ((i, c) in S.withIndex()) {
            when (c) {
                '1' -> {
                    val cur = Tree(i)
                    stack.peek().sub.add(cur)
                    stack.add(cur)
                }
                '0' -> {
                    val cur = stack.pop()
                    cur.end = i+1
                }
            }
        }

        return mkStr(root).let { it.substring(1, it.lastIndex) }
    }
}

fun main(args: Array<String>) {
    println(Solution761().makeLargestSpecial("11011000"))
}
