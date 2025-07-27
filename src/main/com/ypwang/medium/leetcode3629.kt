package com.ypwang.medium

import java.util.*

class Solution3629 {
    fun factor(x: Int): List<Int> {
        val res = mutableListOf<Int>()
        var xVar = x
        var d = 2
        while (d * d <= xVar) {
            if (xVar % d == 0) {
                res.add(d)
                while (xVar % d == 0)
                    xVar /= d
            }
            d++
        }
        if (xVar > 1)
            res.add(xVar)

        return res
    }

    fun minJumps(nums: IntArray): Int {
        val adj = mutableMapOf<Int, MutableList<Int>>()
        val n = nums.size
        for (i in 0 until n) {
            val temp = factor(nums[i])
            for (it in temp)
                adj.getOrPut(it) { mutableListOf() }.add(i)
        }

        val dist = IntArray(n) { Int.MAX_VALUE }
        val q = PriorityQueue(compareBy<Pair<Int, Int>> { it.first })
        q.add(0 to 0)
        dist[0] = 0

        while (q.isNotEmpty()) {
            val (dis, node) = q.poll()

            if (node + 1 < n && dist[node + 1] > dis + 1) {
                dist[node + 1] = dis + 1
                q.add(dist[node + 1] to node + 1)
            }
            if (node - 1 >= 0 && dist[node - 1] > dis + 1) {
                dist[node - 1] = dis + 1
                q.add(dist[node - 1] to node - 1)
            }

            for (idx in adj.getOrDefault(nums[node], emptyList())) {
                if (dist[idx] > dis + 1) {
                    dist[idx] = dis + 1
                    q.add(dist[idx] to idx)
                }
            }
            adj.remove(nums[node])
        }

        return dist[n - 1]
    }
}

fun main() {
    println(Solution3629().minJumps(intArrayOf(4, 6, 5, 8)))
}