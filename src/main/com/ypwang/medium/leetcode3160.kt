package com.ypwang.medium

class Solution3160 {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val colorToNode = mutableMapOf<Int, MutableSet<Int>>()
        val nodeToColor = mutableMapOf<Int, Int>()

        val rst = IntArray(queries.size)

        for ((i, arr) in queries.withIndex()) {
            val (x, y) = arr
            if (x in nodeToColor) {
                val c = nodeToColor[x]
                colorToNode[c]!!.remove(x)
                if (colorToNode[c]!!.isEmpty())
                    colorToNode.remove(c)
            }

            nodeToColor[x] = y
            colorToNode.getOrPut(y) { mutableSetOf() }.add(x)
            rst[i] = colorToNode.size
        }

        return rst
    }
}
