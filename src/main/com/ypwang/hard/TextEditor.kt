package com.ypwang.hard

import java.util.*

class TextEditor {
    private val left = Stack<Char>()
    private val right = Stack<Char>()

    fun addText(text: String) {
        for (c in text)
            left.push(c)
    }

    fun deleteText(k: Int): Int {
        val cnt = minOf(left.size, k)
        for (i in 0 until cnt)
            left.pop()
        return cnt
    }

    fun cursorLeft(k: Int): String {
        val cnt = minOf(left.size, k)
        for (i in 0 until cnt)
            right.push(left.pop())
        return leftString()
    }

    fun cursorRight(k: Int): String {
        val cnt = minOf(right.size, k)
        for (i in 0 until cnt)
            left.push(right.pop())
        return leftString()
    }

    private fun leftString(): String {
        val cnt = minOf(left.size, 10)
        val sb = StringBuilder()
        for (i in 0 until cnt)
            sb.append(left.pop())

        val rst = sb.toString().reversed()
        for (c in rst)
            left.push(c)

        return rst
    }
}
