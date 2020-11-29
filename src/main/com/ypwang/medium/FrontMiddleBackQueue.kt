package com.ypwang.medium

import java.util.*

class FrontMiddleBackQueue() {
    private val front: Deque<Int> = LinkedList()
    private val back: Deque<Int> = LinkedList()

    fun pushFront(`val`: Int) {
        front.offerFirst(`val`)
        if (front.size > back.size) {
            back.offerFirst(front.pollLast())
        }
    }

    fun pushMiddle(`val`: Int) {
        front.offerLast(`val`)
        if (front.size > back.size) {
            back.offerFirst(front.pollLast())
        }
    }

    fun pushBack(`val`: Int) {
        back.offerLast(`val`)
        if (back.size > front.size+1) {
            front.offerLast(back.pollFirst())
        }
    }

    fun popFront(): Int {
        val rst = front.pollFirst() ?: back.pollFirst() ?: -1
        if (back.size > front.size+1) {
            front.offerLast(back.pollFirst())
        }

        return rst
    }

    fun popMiddle(): Int {
        val rst = if (back.size > front.size)
            back.pollFirst()
        else if (front.size > 0)
            front.pollLast()
        else -1

        return rst
    }

    fun popBack(): Int {
        val rst = back.pollLast() ?: -1
        if (front.size > back.size) {
            back.offerFirst(front.pollLast())
        }

        return rst
    }
}