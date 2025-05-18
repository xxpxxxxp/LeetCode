package com.ypwang.medium

import java.util.Deque
import java.util.LinkedList
import kotlin.collections.ArrayList
import kotlin.collections.MutableList

class Solution3552 {
    fun solve(mat: Array<String>, pos: Array<MutableList<IntArray>>): Int {
        val n = mat.size
        val m = mat[0].length
        if (mat[0][0] == '#' || mat[n - 1][m - 1] == '#')
            return -1

        val dist: Array<IntArray> = Array(n) { IntArray(m) { Int.MAX_VALUE } }

        val used = BooleanArray(26)
        val q: Deque<IntArray> = LinkedList()
        dist[0][0] = 0
        q.addFirst(intArrayOf(0, 0))

        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        while (q.isNotEmpty()) {
            val (x, y) = q.pollFirst()
            val d = dist[x][y]
            if (x == n - 1 && y == m - 1)
                return d

            val c = mat[x][y]
            if (c >= 'A' && c <= 'Z') {
                val idx = c - 'A'
                if (!used[idx]) {
                    used[idx] = true
                    for ((px, py) in pos[idx]) {
                        if (d < dist[px][py]) {
                            dist[px][py] = d
                            q.addFirst(intArrayOf(px, py))
                        }
                    }
                }
            }

            for ((dx, dy) in dirs) {
                val newX = x + dx
                val newY = y + dy
                if (newX in 0 until n && newY in 0 until m && mat[newX][newY] != '#' && d + 1 < dist[newX][newY]) {
                    dist[newX][newY] = d + 1
                    q.addLast(intArrayOf(newX, newY))
                }
            }
        }

        return -1
    }

    fun minMoves(matrix: Array<String>): Int {
        val n = matrix.size
        val m = matrix[0].length

        val pos = Array<MutableList<IntArray>>(26) { mutableListOf() }
        for (i in 0..25) pos[i] = ArrayList<IntArray>()
        for (i in 0..<n) {
            for (j in 0..<m) {
                val c = matrix[i][j]
                if (c >= 'A' && c <= 'Z') {
                    pos[c - 'A'].add(intArrayOf(i, j))
                }
            }
        }
        return solve(matrix, pos)
    }
}
