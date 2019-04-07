package com.ypwang.medium

class Solution957 {
    private fun toInt(cells: IntArray): Int {
        var cur = 0
        for ((i, v) in cells.withIndex()) {
            if (v and 0xf == 1)
                cur = cur or (1 shl i)
        }
        return cur
    }

    fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
        val round = mutableMapOf(0 to toInt(cells))
        val values = mutableMapOf(round[0] to 0)

        var count = 1
        while (count <= N) {
            // simulate
            for (i in 0 until cells.size) {
                if (i == 0 || i == cells.lastIndex || (cells[i-1] and 0xf) != (cells[i+1] and 0xf))
                    cells[i] = cells[i] and 0xf
                else cells[i] = cells[i] or 0x10
            }

            for (i in 0 until cells.size) {
                cells[i] = cells[i] shr 4
            }

            val t = toInt(cells)
            if (t in values)
                break

            round[count] = t
            values[t] = count
            count++
        }

        val t = if (count == (N + 1)) round[N]!! else {
            val last = values[toInt(cells)]!!
            round[(N - last) % (count - last) + last]!!
        }
        for (i in 0 until cells.size) { cells[i] = (t shr i) and 0x1 }
        return cells
    }
}

fun main() {
    println(Solution957().prisonAfterNDays(intArrayOf(1,0,0,1,0,0,1,0), 1000000000).toList())
}