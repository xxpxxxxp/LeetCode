package com.ypwang.hard

class TreeAncestor(n: Int, parent: IntArray) {
    private val jump = mutableListOf<IntArray>()

    init {
        jump.add(parent)
        var cur = parent
        for (i in 0 until 15) {
            val next = IntArray(cur.size)
            for (j in next.indices)
                next[j] = if (cur[j] in cur.indices) cur[cur[j]] else -1

            jump.add(next)
            cur = next
        }
    }

    fun getKthAncestor(node: Int, k: Int): Int {
        var cur = node
        var c = k

        for ((i, arr) in jump.withIndex().reversed()) {
            if (cur == -1 || c == 0) return cur
            val bit = 1 shl i
            if (c >= bit) {
                cur = arr[cur]
                c -= bit
            }
        }

        return cur
    }
}

fun main() {
    val tree = TreeAncestor(7, intArrayOf(-1,0,0,1,1,2,2))
    println(tree.getKthAncestor(3,1))
    println(tree.getKthAncestor(5,2))
    println(tree.getKthAncestor(6,3))
}