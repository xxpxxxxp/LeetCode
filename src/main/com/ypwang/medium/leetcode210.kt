package com.ypwang.medium

class Solution210 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        // first: depends on sb
        // second: sb depends on me
        val trees = (0 until numCourses).map {
            Pair(it, Pair(mutableSetOf<Int>(), mutableListOf<Int>()))
        }.toMap().toMutableMap()

        for (depends in prerequisites) {
            val dependsBy = depends[0]
            val dependsOn = depends[1]
            trees[dependsBy]!!.first.add(dependsOn)
            trees[dependsOn]!!.second.add(dependsBy)
        }

        val output = mutableListOf<Int>()
        while (trees.isNotEmpty()) {
            val n =
                    trees.filter { it.value.first.isEmpty() }

            if (n.isEmpty()) {
                return intArrayOf()
            }

            for ((key, value) in n) {
                output.add(key)
                for (i in value.second) {
                    trees[i]!!.first.remove(key)
                }
                trees.remove(key)
            }
        }

        return output.toTypedArray().toIntArray()
    }
}

fun main() {
    println(Solution210().findOrder(4, arrayOf(
            intArrayOf(1,0), intArrayOf(2,0), intArrayOf(3,1), intArrayOf(3,2)
    )).toList())
}