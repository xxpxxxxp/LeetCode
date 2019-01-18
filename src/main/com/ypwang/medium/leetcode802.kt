package com.ypwang.medium

import java.io.File
import java.util.*

class Solution802 {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val color = IntArray(graph.size)
        val ans = mutableListOf<Int>()

        for (i in 0 until graph.size)
            if (dfs(i, color, graph))
                ans.add(i)
        return ans
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;
    private fun dfs(node: Int, color: IntArray, graph: Array<IntArray>): Boolean {
        if (color[node] > 0)
            return color[node] == 2

        color[node] = 1
        for (nei in graph[node]) {
            if (color[node] == 2)
                continue
            if (color[nei] == 1 || !dfs(nei, color, graph))
                return false
        }

        color[node] = 2
        return true
    }
}

fun main(args: Array<String>) {
    val input = File("C:\\Users\\yupen\\Desktop\\mememe.txt").readText()
    val array = input.substring(2, input.length - 2)    // remove [[ of begin, ]] of end
        .split("[").map { it.removeSuffix("],") }.map{
        if (it.isEmpty()) intArrayOf()
        else it.split(",").map { i -> i.toInt() }.toIntArray()
    }.toTypedArray()

    println(array.size)

    val now = Date()
    println(Solution802().eventualSafeNodes(array))
    println("Cost: ${Date().time - now.time} milliseconds")
}