package com.ypwang.hard

class Solution3311 {
    fun constructGridLayout(n: Int, edges: Array<IntArray>): Array<IntArray> {
        // building the graph
        val graph = mutableMapOf<Int, MutableSet<Int>>()
        for ((a, b) in edges) {
            graph.computeIfAbsent(a) { mutableSetOf() }.add(b)
            graph.computeIfAbsent(b) { mutableSetOf() }.add(a)
        }

        // corner node search
        var minEdges = n
        var minNode = -1
        for ((node, cnt) in graph) {
            if (cnt.size < minEdges) {
                minEdges = cnt.size
                minNode = node
            }
        }

        // building grid diagonal layer by layer
        val diags = mutableListOf<MutableList<Int>>()
        val visited = BooleanArray(n)
        var nodesCnt = 1
        diags.add(mutableListOf(minNode))
        visited[minNode] = true
        var h = 1
        var w = 1
        var hwLimited = false
        while (nodesCnt < n) {
            val lastLayer = diags.last()
            val nextLayer = mutableListOf<Int>()
            // processing next cells with 2 predecessors
            for (i in 1 until lastLayer.size) {
                val node1 = lastLayer[i - 1]
                val node2 = lastLayer[i]
                val commonNeibs = graph[node1]?.intersect(graph[node2] ?: emptySet())?.toMutableSet() ?: mutableSetOf()
                for (next in commonNeibs) {
                    if (!visited[next]) {
                        nextLayer.add(next)
                        visited[next] = true
                        nodesCnt++
                        break
                    }
                }
            }
            // border cells with 1 predecessor left:
            // top-right border
            var firstFound = false
            for (nextBorder in graph[lastLayer.first()] ?: emptySet()) {
                if (!visited[nextBorder]) {
                    nextLayer.add(0, nextBorder) // O(diag.size) but once per diag
                    visited[nextBorder] = true
                    nodesCnt++
                    firstFound = true
                    break
                }
            }
            // bottom-left border
            var lastFound = false
            for (nextBorder in graph[lastLayer.last()] ?: emptySet()) {
                if (!visited[nextBorder]) {
                    nextLayer.add(nextBorder)
                    visited[nextBorder] = true
                    nodesCnt++
                    lastFound = true
                    break
                }
            }
            diags.add(nextLayer)

            // keeping track of grid size
            if (lastLayer.size + 1 == nextLayer.size) {
                h++
                w++
            } else if (!hwLimited) { // we freeze sides once
                if (firstFound) {
                    w++
                } else {
                    h++
                }
                hwLimited = true
            }
        }

        // the min side is correct, the other one should be reconstructed
        var hw = diags.size + 1 // diags.size = h + w - 1
        if (h < w) {
            w = hw - h
        } else {
            h = hw - w
        }

        // building the final result: copying diagonals one by one
        val result = Array(h) { IntArray(w) }
        var dNum = 0
        var firstRow = 0
        for (diag in diags) {
            var row = firstRow
            var col = dNum - row
            if (col == w) {
                firstRow++
                row++
                col--
            }
            for (node in diag) {
                result[row++][col--] = node
            }
            dNum++
        }
        return result
    }
}
