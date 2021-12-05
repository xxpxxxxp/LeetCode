package com.ypwang.hard

import java.util.*

class Solution2097 {
    fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val cin = mutableMapOf<Int, Int>()
        val cout = mutableMapOf<Int, Int>()

        for ((u, v) in pairs) {
            graph.getOrPut(u, { mutableListOf() }).add(v)
            cout[u] = cout.getOrDefault(u, 0) + 1
            cin[v] = cin.getOrDefault(v, 0) + 1
        }

        var start = pairs[0][0]
        for ((k, v) in cout) {
            if (v - cin.getOrDefault(k, 0) == 1) {
                start = k
                break
            }
        }

        val route = mutableListOf<Int>()
        val stack = Stack<Int>()
        stack.push(start)

        while (stack.isNotEmpty()) {
            while (graph[stack.peek()]?.isNotEmpty() == true) {
                val ls = graph[stack.peek()]!!
                stack.push(ls.removeAt(ls.lastIndex))
            }
            route.add(stack.pop())
        }

        route.reverse()
        return (0 until route.lastIndex).map { intArrayOf(route[it], route[it+1]) }.toTypedArray()
    }
}

fun main() {
    println(Solution2097().validArrangement(arrayOf(intArrayOf(5,1), intArrayOf(4,5), intArrayOf(11,9), intArrayOf(9,4))))
}