package com.ypwang.hard

class Solution2056 {
    fun countCombinations(pieces: Array<String>, positions: Array<IntArray>): Int {
        val directions = mapOf(
            "rook" to listOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1)),
            "bishop" to listOf(intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, 1), intArrayOf(-1, -1)),
            "queen" to listOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, 1), intArrayOf(-1, -1))
        )

        val rst = mutableSetOf<Int>()
        fun dfs(dirs: List<IntArray>, pos: Array<IntArray>, mask: Int) {
            if (mask == 0)
                return

            rst.add(pos.flatMap { it.toList() }.joinToString("").toInt())

            for (active in 0 until (1 shl pieces.size)) {
                if (active and mask != active)
                    continue

                val copy = pos.map { it.clone() }.toTypedArray()

                for ((i, arr) in copy.withIndex()) {
                    val move = (active shr i) and 0x1
                    arr[0] =  arr[0] + dirs[i][0] * move
                    arr[1] =  arr[1] + dirs[i][1] * move
                }

                if (copy.map { it.joinToString("") }.toSet().size < copy.size)
                    continue
                if (copy.any { it[0] !in 1..8 || it[1] !in 1..8 })
                    continue

                dfs(dirs, copy, active)
            }
        }

        pieces.map { directions[it]!! }
            .fold(listOf(listOf<IntArray>())) { cur, dirs -> cur.flatMap { a -> dirs.map { b -> a + b } } }
            .forEach { dfs(it, positions, (1 shl pieces.size) - 1) }

        rst.forEach { println(it) }
        return rst.size
    }
}

fun main() {
    println(Solution2056().countCombinations(arrayOf("rook", "rook"), arrayOf(intArrayOf(1,1), intArrayOf(8,8))))
//    println(Solution2056().countCombinations(arrayOf("queen"), arrayOf(intArrayOf(1,1))))
}