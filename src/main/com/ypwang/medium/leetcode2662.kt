package com.ypwang.medium

import java.util.PriorityQueue

class Solution2662 {
    fun minimumCost(start: IntArray, target: IntArray, specialRoads: Array<IntArray>): Int {
        val roads = specialRoads.filter { (a,b,c,d,x) -> x < Math.abs(a-c) + Math.abs(b-d) }
        val dis = mutableMapOf((start[0] to start[1]) to 0)
        val heap = PriorityQueue<Pair<Int, IntArray>>(compareBy { it.first })
        heap.add(0 to start)
        while (heap.isNotEmpty()) {
            val (cur, p) = heap.poll()
            val (x, y) = p
            for ((a,b,c,d,cost) in roads) {
                if (dis.getOrDefault(c to d, Int.MAX_VALUE) > cur + Math.abs(x-a) + Math.abs(y-b) + cost) {
                    val arr = c to d
                    dis[arr] = cur + Math.abs(x-a) + Math.abs(y-b) + cost
                    heap.offer(dis[arr]!! to intArrayOf(c,d))
                }
            }
        }
        var rst = Math.abs(target[0] - start[0]) + Math.abs(target[1] - start[1])
        for ((_,_,c,d,_) in roads) {
            val arr = c to d
            if (arr in dis) {
                rst = minOf(rst, dis[arr]!! + Math.abs(target[0] - c) + Math.abs(target[1] - d))
            }
        }
        return rst
    }
}

fun main() {
    println(Solution2662().minimumCost(intArrayOf(1,1), intArrayOf(4,5), arrayOf(
        intArrayOf(1,2,3,3,2), intArrayOf(3,4,4,5,1)
    )))
}