package com.ypwang.hard

import java.util.*

class Solution1203 {
    fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {
        // group id to idxs
        val groupMap = group.withIndex().filter { it.value != -1 }.groupBy { it.value }.mapValues { it.value.map { kv -> kv.index }.toSet() }

        val deps = Array(n){ mutableSetOf<Int>() }
        val notify = Array(n){ mutableSetOf<Int>() }

        for ((_, g) in groupMap) {
            val d = mutableSetOf<Int>()
            for (j in g) {
                deps[j] = d
            }
        }

        val groupInnerDep = Array(m){ mutableListOf<Pair<Int, Int>>() }
        for ((i, dep) in beforeItems.withIndex()) {
            for (j in dep) {
                if (group[i] != -1 && group[i] == group[j]) {
                    // group inner dep
                    groupInnerDep[group[i]].add(i to j)
                } else {
                    deps[i].add(j)
                    notify[j].add(i)
                }
            }
        }

        fun outputGroup(id: Int): List<Int> {
            val rst = mutableListOf<Int>()

            val bfs: Queue<Int> = LinkedList()
            val dep = mutableMapOf<Int, MutableSet<Int>>()
            val noti = mutableMapOf<Int, MutableSet<Int>>()
            for ((i, j) in groupInnerDep[id]) {
                if (i !in dep) dep[i] = mutableSetOf()
                if (j !in noti) noti[j] = mutableSetOf()

                dep[i]!!.add(j)
                noti[j]!!.add(i)
            }

            bfs.addAll(groupMap[id]!!.filter { it !in dep })
            while (bfs.isNotEmpty()) {
                val i = bfs.poll()
                rst.add(i)
                if (i in noti) {
                    for (j in noti[i]!!) {
                        dep[j]!!.remove(i)
                        if (dep[j]!!.isEmpty())
                            bfs.add(j)
                    }
                }
            }

            return rst
        }

        val visited = BooleanArray(n)
        val rst = mutableListOf<Int>()
        val bfs: Queue<Int> = LinkedList()
        bfs.addAll(deps.withIndex().filter { it.value.isEmpty() }.map { it.index })

        while (bfs.isNotEmpty()) {
            val i = bfs.poll()
            if (visited[i]) continue
            if (group[i] == -1) {
                // single val
                visited[i] = true
                rst.add(i)
                notify[i].forEach {
                    deps[it].remove(i)
                    if (deps[it].isEmpty())
                        bfs.add(it)
                }
            } else {
                groupMap[group[i]]!!.forEach {
                    visited[it] = true
                    notify[it].forEach { j ->
                        deps[j].remove(it)
                        if (deps[j].isEmpty())
                            bfs.add(j)
                    }
                }
                rst.addAll(outputGroup(group[i]))
            }
        }

        return if (rst.size == n) rst.toIntArray() else intArrayOf()
    }
}

fun main() {
    println(Solution1203().sortItems(5, 5, intArrayOf(2,0,-1,3,0), listOf(
            listOf(2,1,3), listOf(2,4), listOf(), listOf(), listOf()
    )).toList())

    println(Solution1203().sortItems(8, 2, intArrayOf(-1,-1,1,0,0,1,0,-1), listOf(
            listOf(), listOf(6), listOf(5), listOf(6), listOf(3, 6), listOf(), listOf(), listOf()
    )).toList())
}