package com.ypwang.medium

import java.util.*

class Solution1081 {
    fun smallestSubsequence(text: String): String {
        val lastPos = text.withIndex().groupBy { it.value }.mapValues { it.value.map { kv -> kv.index }.max()!! }

        val stack = Stack<Char>()
        val track = mutableSetOf<Char>()

        for ((i, c) in text.withIndex()) {
            if (c !in track) {
                while (stack.isNotEmpty() && stack.peek() > c && lastPos[stack.peek()]!! > i) {
                    track.remove(stack.pop())
                }
                stack.add(c)
                track.add(c)
            }
        }

        return stack.joinToString("")
    }
}