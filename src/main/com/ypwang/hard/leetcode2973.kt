package com.ypwang.hard

class Solution10034 {
    fun placedCoins(edges: Array<IntArray>, cost: IntArray): LongArray {
        val grid = Array(edges.size+1) { mutableListOf<Int>() }

        for ((a, b) in edges) {
            grid[a].add(b)
            grid[b].add(a)
        }

        val rst = LongArray(edges.size + 1)

        // 1. positive costs, max 3
        // 2. negative costs, max 2
        // 3. subtree size
        fun recursive(pre: Int, idx: Int): Triple<List<Int>, List<Int>, Int> {
            val positive = mutableListOf<Int>()
            val negative = mutableListOf<Int>()

            if (cost[idx] >= 0)
                positive.add(cost[idx])
            else
                negative.add(cost[idx])

            var size = 1

            for (next in grid[idx]) {
                if (next == pre)
                    continue

                val (pos, neg, len) = recursive(idx, next)
                positive.addAll(pos)
                negative.addAll(neg)
                size += len
            }

            positive.sortDescending()
            negative.sort()

            if (size < 3)
                rst[idx] = 1L
            else {
                var coins = 0L
                if (positive.size >= 3)
                    coins = positive.take(3).fold(1L) { a, b -> a * b }
                if (positive.isNotEmpty() && negative.size >= 2)
                    coins = maxOf(coins, positive[0].toLong() * negative[0] * negative[1])

                rst[idx] = coins
            }

            return Triple(positive.take(3), negative.take(2), size)
        }

        recursive(-1, 0)

        return rst
    }
}

fun main() {
    println(Solution10034().placedCoins(arrayOf(
        intArrayOf(0,1),intArrayOf(0,2), intArrayOf(0,3), intArrayOf(0,4), intArrayOf(0,5)
    ), intArrayOf(1,2,3,4,5,6)).toList())
}