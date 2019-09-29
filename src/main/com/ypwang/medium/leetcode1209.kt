package com.ypwang.medium

import java.lang.StringBuilder
import java.util.*

class Solution1209 {
    data class Item(val c: Char, var count: Int)

    fun removeDuplicates(s: String, k: Int): String {
        val stack = Stack<Item>()

        for (c in s) {
            if (stack.isNotEmpty() && stack.peek().c == c) {
                if (stack.peek().count == k-1) stack.pop()
                else stack.peek().count++
            } else {
                stack.add(Item(c, 1))
            }
        }

        val sb = StringBuilder()
        for (item in stack) {
            for (i in 0 until item.count)
                sb.append(item.c)
        }

        return sb.toString()
    }
}