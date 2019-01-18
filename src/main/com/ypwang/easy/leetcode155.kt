package com.ypwang.easy

class MinStack {
    val stack = mutableListOf<Int>()
    val minStack = mutableListOf<Pair<Int, Int>>()
    var count = 0

    fun push(x: Int) {
        stack.add(x)

        if (minStack.isEmpty() || minStack.last().first > x) {
            minStack.add(Pair(x, count))
        }
        count++
    }

    fun pop() {
        val index = stack.lastIndex
        stack.removeAt(stack.lastIndex)
        if (minStack.last().second == index) {
            minStack.removeAt(minStack.lastIndex)
        }
        count--
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last().first
    }
}

fun main(args: Array<String>) {
    val obj = MinStack()
    obj.push(-2)
    obj.push(0)
    obj.push(-3)
    println(obj.getMin())
    obj.pop()
    println(obj.top())
    println(obj.getMin())
}