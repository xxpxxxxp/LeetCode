package com.ypwang.medium

class MyCircularQueue(k: Int) {
    /** Initialize your data structure here. Set the size of the queue to be k. */
    private val array = Array(k+1){0}
    private var begin = 0
    private var end = 0

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        if (isFull())
            return false

        array[end] = value
        end = (end + 1) % array.size
        return true
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        if (isEmpty())
            return false

        begin = (begin + 1) % array.size
        return true
    }

    /** Get the front item from the queue. */
    fun Front(): Int = if (isEmpty()) -1 else array[begin]

    /** Get the last item from the queue. */
    fun Rear(): Int = if (isEmpty()) -1 else array[(array.size + end - 1) % array.size]

    /** Checks whether the circular queue is empty or not. */
    fun isEmpty(): Boolean = begin == end

    /** Checks whether the circular queue is full or not. */
    fun isFull(): Boolean = (end + 1) % array.size == begin
}

fun main() {
    val q = MyCircularQueue(3)
    println(q.enQueue(1))
    println(q.enQueue(2))
    println(q.enQueue(3))
    println(q.enQueue(4))
    println(q.Rear())
    println(q.isFull())
    println(q.deQueue())
    println(q.enQueue(4))
    println(q.Rear())
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */