package com.ypwang.medium

class CustomStack(private val maxSize: Int) {
    private val inc = IntArray(maxSize)
    private val stack = IntArray(maxSize)
    private var pos = 0

    fun push(x: Int) {
        if (pos != maxSize)
            stack[pos++] = x
    }

    fun pop(): Int {
        if (pos == 0) return -1     // nothing to pop
        pos--
        if (pos > 0) {
            inc[pos-1] += inc[pos]
        }
        val v = stack[pos] + inc[pos]
        inc[pos] = 0

        return v
    }

    fun increment(k: Int, `val`: Int) {
        val idx = minOf(k, pos) - 1
        if (idx >= 0)
            inc[idx] += `val`
    }
}

fun main() {
    val s = CustomStack(3)
    s.push(1)
    s.push(2)
    println(s.pop())
    s.push(2)
    s.push(3)
    s.push(4)
    s.increment(5, 100)
    s.increment(2, 100)
    println(s.pop())
    println(s.pop())
    println(s.pop())
    println(s.pop())
}