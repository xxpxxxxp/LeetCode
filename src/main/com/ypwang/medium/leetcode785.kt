package com.ypwang.medium

class Solution785 {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val relations = graph.withIndex().flatMap {
            fm -> fm.value.map { Pair(fm.index, it) }
        }.groupBy { it.first }.mapValues { it.value.map { kv -> kv.second } }

        val visited = mutableSetOf<Int>()
        for ((i, _) in relations) {
            if (i !in visited) {
                val contra = Array(2) { mutableSetOf<Int>() }

                fun add(index: Int, toContraIndex: Int): Boolean {
                    if (index in contra[toContraIndex]) {
                        return true
                    }

                    contra[toContraIndex].add(index)
                    visited.add(index)
                    val opposite = relations[index]!!
                    if (opposite.any { it in contra[toContraIndex] })
                        return false

                    val oppositeContra = (toContraIndex + 1) % 2
                    return opposite.all { add(it, oppositeContra) }
                }

                if (!add(i, 0))
                    return false
            }
        }
        return true
    }
}

fun main() {
    println(Solution785().isBipartite(
//            arrayOf(
//                    intArrayOf(1,3),
//                    intArrayOf(0,2),
//                    intArrayOf(1,3),
//                    intArrayOf(0,2)
//            )
            arrayOf(
                    intArrayOf(1,2,3),
                    intArrayOf(0,2),
                    intArrayOf(0,1,3),
                    intArrayOf(0,2)
            )
    ))
}