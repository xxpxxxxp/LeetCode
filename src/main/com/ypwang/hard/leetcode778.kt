package com.ypwang.hard

import java.util.*

class Solution778 {
    private val surround = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun swimInWater(grid: Array<IntArray>): Int {
        val heap = PriorityQueue<Pair<Int, Int>>(Comparator { o1, o2 -> o1.first - o2.first })
        heap.add(grid[0][0] to 0)
        val seen = mutableSetOf<Int>()

        var max = 0
        val N = grid.size
        val target = grid.last().last()
        while (heap.peek().first != target) {
            val (`val`, idx) = heap.poll()
            max = maxOf(max, `val`)
            seen.add(idx)

            val x = idx % 100
            val y = idx / 100

            for (s in surround) {
                val xx = x + s.first
                val yy = y + s.second
                val idt = yy * 100 + xx
                if (idt !in seen && xx in 0 until N && yy in 0 until N) {
                    heap.add(grid[yy][xx] to idt)
                }
            }
        }

        return maxOf(max, target)
    }
}

fun main() {
    println(Solution778().swimInWater(arrayOf(intArrayOf(0,2), intArrayOf(1,3))))
    println(Solution778().swimInWater(arrayOf(intArrayOf(0,1,2,3,4), intArrayOf(24,23,22,21,5), intArrayOf(12,13,14,15,16), intArrayOf(11,17,18,19,20), intArrayOf(10,9,8,7,6))))
}