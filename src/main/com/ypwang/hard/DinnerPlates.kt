package com.ypwang.hard

import java.util.*

class DinnerPlates(val capacity: Int) {
    val stack = mutableListOf<Stack<Int>>()
    val q = PriorityQueue<Int>()

    fun push(`val`: Int) {
        while (q.isNotEmpty() && q.peek() < stack.size && stack[q.peek()].size == capacity)
            q.poll()
        if (q.isEmpty())
            q.offer(stack.size)
        if (q.peek() == stack.size)
            stack.add(Stack())
        stack[q.peek()].push(`val`)
    }

    fun pop(): Int {
        while (stack.isNotEmpty() && stack.last().isEmpty())
            stack.removeAt(stack.lastIndex)

        return popAtStack(stack.size - 1)
    }

    fun popAtStack(index: Int): Int {
        if (index in 0 until stack.size && stack[index].isNotEmpty()) {
            q.offer(index)
            return stack[index].pop()
        }
        return -1
    }
}