package com.ypwang.hard

class Skiplist() {
    private data class Node(val `val`: Int, var next: Node? = null, var down: Node? = null)

    private val rand = java.util.Random()
    private val head = mutableListOf(Node(Int.MIN_VALUE))

    private fun searchPath(target: Int): List<Node> {
        val res = mutableListOf<Node>()
        var cur: Node? = head.first()
        while (cur != null) {
            while (cur!!.next != null && cur.next!!.`val` < target)
                cur = cur.next!!

            res.add(0, cur)
            cur = cur.down
        }

        return res
    }

    private fun flipCoin(): Boolean = rand.nextInt() % 2 == 0

    fun search(target: Int): Boolean =
            searchPath(target).first().let { it.next != null && it.next!!.`val` == target }

    fun add(num: Int) {
        val res = searchPath(num)
        var pre: Node? = null

        var count = 0
        for (node in res) {
            val n = Node(num)
            n.down = pre
            n.next = node.next
            node.next = n

            pre = n
            count++
            if (flipCoin()) break
        }

        // check if we need to add 1 more layer
        if (count == res.size && flipCoin()) {
            val n = Node(num)
            n.down = pre
            val dummy = Node(Int.MIN_VALUE)
            dummy.next = n
            dummy.down = head.first()
            head.add(0, dummy)
        }
    }

    fun erase(num: Int): Boolean {
        val res = searchPath(num)

        var found = false
        for (node in res) {
            if (node.next != null && node.next!!.`val` == num) {
                node.next = node.next!!.next
                found = true
            }
        }

        head.removeIf { it.next == null }

        return found
    }
}

fun main() {
    while (true) {
        val skiplist = Skiplist()
        skiplist.add(0)
        skiplist.add(5)
        skiplist.add(2)
        skiplist.add(1)
        skiplist.search(0)
        val t = skiplist.erase(5)
        skiplist.search(2)
        skiplist.search(3)
        skiplist.search(2)
    }
}