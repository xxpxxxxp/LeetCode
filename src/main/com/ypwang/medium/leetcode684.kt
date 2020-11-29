package com.ypwang.medium

class Solution684 {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val heads = Array(edges.size){ it }

        for (edge in edges) {
            var head = edge[0] - 1
            var value = edge[1] - 1

            // find head's head
            while (head != heads[head]) {
                head = heads[head]
            }

            while (value != heads[value]) {
                value = heads[value]
            }

            if (head == value) {
                return edge
            }

            heads[value] = head
        }

        return intArrayOf()
    }
}

fun main() {
    println(Solution684().findRedundantConnection(
            arrayOf(
                    intArrayOf(1,2),
                    intArrayOf(2,3),
                    intArrayOf(3,4),
                    intArrayOf(1,4),
                    intArrayOf(1,5)
            )
    ).toList())
}
