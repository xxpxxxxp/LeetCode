package com.ypwang.medium

class Solution4085 {
    fun getColor(c: Char): Int {
        if (c == 'R') return 0
        if (c == 'B') return 1
        return 2
    }

    fun findColoredRoot(edges: Array<IntArray>, colors: String): Int {
        // r=0, b = 1, w = 2
        // next color = (cu + 1) % 3
        // at most two children 
        val n = colors.length
        val ind = IntArray(n)
        val oud = IntArray(n)

        for (i in 0 until n - 1) {
            val (u, v) = edges[i]
            val cu = getColor(colors[u])
            val cv = getColor(colors[v])

            if (cu == cv)
                return -1

            // we want the edge in forward direction means r -> b || b -> w || w -> r 
            if ((cv - cu + 3) % 3 == 1) {
                // connect u -> v 
                oud[u] = oud[u] + 1
                ind[v] = ind[v] + 1
            } else {
                // connect v -> u 
                oud[v] = oud[v] + 1
                ind[u] = ind[u] + 1
            }
        }

        var root = -1 // any root
        for (i in 0 until n) {
            // each node must have a ind - only 1 or none 
            // out < 2 
            if (oud[i] > 2 || ind[i] > 1)
                return -1
            if (ind[i] == 0) {
                if (root != -1)
                    return -1 // two can not be root

                // this can be root 
                root = i
            }
        }

        return root
    }
}
