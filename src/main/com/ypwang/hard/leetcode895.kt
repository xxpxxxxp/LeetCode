package com.ypwang.hard

class FreqStack {
    class DoublyLinkedList(val value: Int) {
        val pos = mutableListOf<Int>()

        var pre: DoublyLinkedList? = null
        var next: DoublyLinkedList? = null
    }

    val map = mutableMapOf<Int, DoublyLinkedList>()
    val start: DoublyLinkedList
    val end: DoublyLinkedList

    init {
        start = DoublyLinkedList(0)
        end = DoublyLinkedList(0)

        start.pos.add(Int.MAX_VALUE)
        end.pos.add(Int.MIN_VALUE)
        start.next = end
        end.pre = start
    }

    var pos = 0
    fun push(x: Int) {
        var (cur, proceed) =
            if (x in map) {
                val cur = map[x]!!
                cur.pos.add(pos++)

                // pick me out
                cur.pre!!.next = cur.next
                cur.next!!.pre = cur.pre

                cur to cur.pre!!
            } else {
                val cur = DoublyLinkedList(x)
                cur.pos.add(pos++)
                map[x] = cur
                // let's start with end
                cur to end
            }

        while (proceed.pos.size <= cur.pos.size && proceed.pos.last() <= cur.pos.last())
            proceed = proceed.pre!!

        // insert me here
        cur.next = proceed.next
        cur.pre = proceed
        proceed.next!!.pre = cur
        proceed.next = cur
    }

    fun pop(): Int {
        val cur = start.next!!
        val value = cur.value
        if (cur.pos.size == 1) {
            // remove it
            map.remove(cur.value)
            cur.pre!!.next = cur.next
            cur.next!!.pre = cur.pre
        } else {
            cur.pos.removeAt(cur.pos.lastIndex)

            // pick me out
            cur.pre!!.next = cur.next
            cur.next!!.pre = cur.pre

            // move cur back
            var proceed = cur.next!!
            while (proceed.pos.size > cur.pos.size || (proceed.pos.size == cur.pos.size && proceed.pos.last() > cur.pos.last()))
                proceed = proceed.next!!

            // insert me before
            cur.next = proceed
            cur.pre = proceed.pre
            proceed.pre!!.next = cur
            proceed.pre = cur
        }

        return value
    }
}

fun main() {
    val stack = FreqStack()
    stack.push(5)
    stack.push(7)
    stack.push(5)
    stack.push(7)
    stack.push(4)
    stack.push(5)
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
}