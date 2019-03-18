package com.ypwang.medium

fun main() {
    val i = PeekingIterator(listOf(1,2,3,4).iterator())
    i.hasNext()
    i.peek()
    i.peek()
    i.next()
    i.next()
    i.peek()
    i.peek()
    i.next()
    i.hasNext()
    i.peek()
    i.hasNext()
    i.next()
    i.hasNext()
}