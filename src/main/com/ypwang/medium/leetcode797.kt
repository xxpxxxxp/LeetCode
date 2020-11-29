package com.ypwang.medium

class Solution797 {
    fun helper(graph: Array<IntArray>, curPos: Int, curList: MutableList<Int>, result: MutableList<List<Int>>) {
        curList.add(curPos)
        if (curPos == graph.lastIndex) {
            result.add(curList.toList())
        } else {
            for (n in graph[curPos]) {
                helper(graph, n, curList, result)
            }
        }

        curList.removeAt(curList.lastIndex)
    }


    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val rst = mutableListOf<List<Int>>()
        helper(graph, 0, mutableListOf(), rst)
        return rst
    }
}

fun main() {
    println(Solution797().allPathsSourceTarget(
            arrayOf(
                    intArrayOf(1,2),
                    intArrayOf(3),
                    intArrayOf(3),
                    intArrayOf()
            )
    ))
}