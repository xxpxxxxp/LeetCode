package com.ypwang.medium

class LRUCache(val capacity: Int) {
    data class DoublyLinkedList(val key: Int, val `val`: Int) {
        var previous: DoublyLinkedList? = null
        var next: DoublyLinkedList? = null
    }

    private val map = mutableMapOf<Int, DoublyLinkedList>()
    private val begin: DoublyLinkedList = DoublyLinkedList(0, 0)
    private val end = DoublyLinkedList(0, 0)

    init {
        begin.next = end
        end.previous = begin
    }

    fun get(key: Int): Int {
        if (key !in map) return -1
        val node = map[key]!!

        node.previous!!.next = node.next
        node.next!!.previous = node.previous

        begin.next!!.previous = node
        node.next = begin.next
        node.previous = begin
        begin.next = node

        return node.`val`
    }

    fun put(key: Int, value: Int) {
        if (key in map) {
            // remove previous key/value
            val node = map[key]!!
            node.previous!!.next = node.next
            node.next!!.previous = node.previous

            map.remove(key)
        }

        if (map.size == capacity) {
            // remove the last one
            val last = end.previous!!

            last.previous!!.next = end
            end.previous = last.previous

            map.remove(last.key)
        }

        val node = DoublyLinkedList(key, value)
        begin.next!!.previous = node
        node.next = begin.next
        begin.next = node
        node.previous = begin

        map[key] = node
    }
}

fun main() {
    val LRU = LRUCache(2)
    println(LRU.get(2))
    println(LRU.put(2,6))
    println(LRU.get(1))
    println(LRU.put(1,5))
    println(LRU.put(1,2))
    println(LRU.get(1))
    println(LRU.get(2))

}