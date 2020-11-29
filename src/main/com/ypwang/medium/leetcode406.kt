package com.ypwang.medium

class Solution406 {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val p = people.sortedWith(
            Comparator { a1, a2 ->
                if (a1[0] == a2[0])
                    a1[1] - a2[1]
                else
                    a2[0] - a1[0]
            }
        )
        val rst = mutableListOf<IntArray>()
        for (q in p) {
            rst.add(q[1], q)
        }
        return rst.toTypedArray()
    }
}

fun main() {
    println(Solution406().reconstructQueue(
            arrayOf(
                    intArrayOf(7, 0), intArrayOf(4, 4), intArrayOf(7, 1), intArrayOf(5, 0), intArrayOf(6, 1),
                    intArrayOf(5, 2)
            )
    ).map { it.toList() })
}