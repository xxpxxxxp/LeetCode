package com.ypwang.hard

class Solution1632 {
    fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
        val m = matrix.size
        val n = matrix[0].size
        val rst = Array(m){ IntArray(n){1} }

        val dfs = IntArray(m * n){ it }

        fun root(i: Int): Int {
            if (dfs[i] != i) dfs[i] = root(dfs[i])
            return dfs[i]
        }

        fun union(i: Int, j: Int) {
            dfs[root(i)] = root(j)
        }

        for (i in 0 until m) {
            val map = mutableMapOf<Int, Int>()
            for (j in 0 until n) {
                val v = matrix[i][j]
                val hash = i * n + j
                if (v in map)
                    union(hash, map[v]!!)
                else
                    map[v] = hash
            }
        }

        for (j in 0 until n) {
            val map = mutableMapOf<Int, Int>()
            for (i in 0 until m) {
                val v = matrix[i][j]
                val hash = i * n + j
                if (v in map)
                    union(hash, map[v]!!)
                else
                    map[v] = hash
            }
        }

        for ((value, idx) in dfs.indices
                .groupBy { root(it) }
                .map { (id, idx) -> matrix[id/n][id%n] to idx }
                .toList()
                .sortedBy { it.first }) {
            val max = idx.map { rst[it/n][it%n] }.maxOrNull()!!
            idx.forEach {
                val i = it/n
                val j = it%n
                rst[i][j] = max

                for (k in 0 until n)
                    if (k != j && matrix[i][k] > value)
                        rst[i][k] = maxOf(max+1, rst[i][k])

                for (k in 0 until m)
                    if (k != i && matrix[k][j] > value)
                        rst[k][j] = maxOf(max+1, rst[k][j])
            }
        }

        return rst
    }
}

fun main() {
    println(Solution1632().matrixRankTransform(arrayOf(
            intArrayOf(-24,-9,-14,-15,44,31,-46,5,20,-5,34),intArrayOf(9,-40,-49,-50,17,40,35,30,-39,36,-49),intArrayOf(-18,-43,-40,-5,-30,9,-28,-41,-6,-47,12),intArrayOf(11,42,-23,20,35,34,-39,-16,27,34,-15),intArrayOf(32,27,-30,29,-48,15,-50,-47,-28,-21,38),intArrayOf(45,48,-1,-18,9,-4,-13,10,9,8,-41),intArrayOf(-42,-35,20,-17,10,5,36,47,6,1,8),intArrayOf(3,-50,-23,16,31,2,-39,36,-25,-30,37),intArrayOf(-48,-41,18,-31,-48,-1,-42,-3,-8,-29,-2),intArrayOf(17,0,31,-30,-43,-20,-37,-6,-43,8,19),intArrayOf(42,25,32,27,-2,45,12,-9,34,17,32)
    )).map { it.toList() })

    println(Solution1632().matrixRankTransform(arrayOf(
            intArrayOf(1,2), intArrayOf(3,4)
    )).map { it.toList() })
    println(Solution1632().matrixRankTransform(arrayOf(
            intArrayOf(7,7), intArrayOf(7,7)
    )).map { it.toList() })
    println(Solution1632().matrixRankTransform(arrayOf(
            intArrayOf(20,-21,14), intArrayOf(-19,4,19), intArrayOf(22,-47,24), intArrayOf(-19,4,19)
    )).map { it.toList() })
    println(Solution1632().matrixRankTransform(arrayOf(
            intArrayOf(7,3,6), intArrayOf(1,4,5), intArrayOf(9,8,2)
    )).map { it.toList() })
}