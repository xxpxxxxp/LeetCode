package com.ypwang.medium

class MyCircularDeque(val k: Int) {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    private val head = mutableListOf<Int>()
    private val tail = mutableListOf<Int>()

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        if (!isFull()) {
            head.add(0, value)
            return true
        }
        return false
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        if (!isFull()) {
            tail.add(value)
            return true
        }
        return false
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (!head.isEmpty()) {
            head.removeAt(0)
            return true
        }

        if (!tail.isEmpty()) {
            tail.removeAt(0)
            return true
        }

        return false
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (!tail.isEmpty()) {
            tail.removeAt(tail.lastIndex)
            return true
        }

        if (!head.isEmpty()) {
            head.removeAt(head.lastIndex)
            return true
        }

        return false
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        if (!head.isEmpty()) {
            return head.first()
        }

        if (!tail.isEmpty()) {
            return tail.first()
        }

        return -1
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        if (!tail.isEmpty()) {
            return tail.last()
        }

        if (!head.isEmpty()) {
            return head.last()
        }

        return -1
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return head.isEmpty() && tail.isEmpty()
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return head.size + tail.size == k
    }

}