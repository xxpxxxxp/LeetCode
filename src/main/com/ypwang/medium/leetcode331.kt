package com.ypwang.medium

import java.util.*

class Solution331 {
    private data class Elem(val value: Int, var leftCheckded: Boolean, var rightChecked: Boolean)

    private fun readInt(iter: CharIterator): Int? {
        var i = 0
        while (iter.hasNext()) {
            val c = iter.next()
            when (c) {
                '#' -> {
                    // read one more ','
                    if (iter.hasNext())
                        iter.next()
                    return null
                }
                ',' -> return i
                else -> i = i * 10 + (c - '0')
            }
        }
        return i
    }

    fun isValidSerialization(preorder: String): Boolean {
        val stack = Stack<Elem>()
        val iter = preorder.iterator()

        val root = readInt(iter) ?: return !iter.hasNext()
        stack.add(Elem(root, false, false))

        while (iter.hasNext()) {
            val i = readInt(iter)
            if (stack.isNotEmpty()) {
                val last = stack.peek()
                when (i) {
                    null -> {}
                    else -> stack.add(Elem(i, false, false))
                }
                if (!last.leftCheckded)  last.leftCheckded = true
                else if (!last.rightChecked) last.rightChecked = true

                while (stack.isNotEmpty()) {
                    val l = stack.peek()
                    if (l.leftCheckded && l.rightChecked) stack.pop()
                    else break
                }
            } else {
                return false
            }
        }

        return stack.isEmpty()
    }
}

fun main() {
    println(Solution331().isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"))
}