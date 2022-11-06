package com.ypwang.medium

import java.util.PriorityQueue

class Solution2462 {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val left = PriorityQueue<Int>()
        val right = PriorityQueue<Int>()
        var i = candidates

        val l = minOf(candidates, maxOf(0, costs.size - candidates))
        var j = costs.size - 1 - l

        left.addAll(costs.take(candidates))
        right.addAll(costs.takeLast(l))

        var sum = 0L
        for (x in 0 until k) {
            if (left.isEmpty())
                sum += right.poll()
            else if (right.isEmpty())
                sum += left.poll()
            else {
                if (left.peek() <= right.peek()) {
                    sum += left.poll()
                    if (i <= j) {
                        left.offer(costs[i++])
                    }
                } else {
                    sum += right.poll()
                    if (i <= j)
                        right.offer(costs[j--])
                }
            }
        }

        return sum
    }
}

fun main() {
    println(Solution2462().totalCost(intArrayOf(31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58)
        ,11
        ,2))
    println(Solution2462().totalCost(intArrayOf(18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75)
        ,13
        ,23))
    println(Solution2462().totalCost(intArrayOf(17,12,10,2,7,2,11,20,8), 3, 4))
    println(Solution2462().totalCost(intArrayOf(1,2,4,1), 3, 3))
}