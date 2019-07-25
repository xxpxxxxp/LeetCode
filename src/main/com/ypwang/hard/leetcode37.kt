package com.ypwang.hard

import java.util.*

class Solution37 {
    fun solveSudoku(board: Array<CharArray>) {
        val possible = (1..9).toSet()
        val horizon = Array(9){ mutableSetOf<Int>() }
        val vertical = Array(9){ mutableSetOf<Int>() }
        val block = Array(9){ mutableSetOf<Int>() }

        val queue: Queue<Pair<Int, Int>> = LinkedList()

        var left = 0
        for (v in 0 until 9) {
            for (h in 0 until 9) {
                if (board[v][h] != '.') {
                    val vv = board[v][h] - '0'
                    horizon[h].add(vv)
                    vertical[v].add(vv)
                    block[(v/3)*3 + h/3].add(vv)
                } else left++
            }
        }

        val hmap = Array(9){ mutableMapOf<Int, MutableSet<Int>>() }
        val vmap = Array(9){ mutableMapOf<Int, MutableSet<Int>>() }
        val bmap = Array(9){ mutableMapOf<Int, MutableSet<Int>>() }

        for (v in 0 until 9) {
            for (h in 0 until 9) {
                if (board[v][h] == '.') {
                    val u = possible.minus(horizon[h].union(vertical[v]).union(block[(v/3)*3 + h/3])).toMutableSet()
                    if (u.size == 1) {
                        queue.offer(h to v)
                        board[v][h] = '0' + u.single()
                        left--
                    } else {
                        hmap[h][v] = u
                        vmap[v][h] = u
                        bmap[(v/3)*3 + h/3][(v%3)*3 + h%3] = u
                    }
                }
            }
        }

        while (left > 0) {
            val cur = queue.poll()
            val h = cur.first
            val v = cur.second
            val vv = board[cur.second][cur.first] - '0'

            for ((idx, set) in hmap[h]) {
                if (board[idx][h] == '.') {
                    set.remove(vv)
                    if (set.size == 1) {
                        left--
                        queue.add(h to idx)
                        vmap[idx].remove(h)
                        bmap[(idx/3)*3 + h/3].remove((idx%3)*3 + h%3)
                        board[idx][h] = '0' + set.single()
                    }
                }
            }

            for ((idx, set) in vmap[v]) {
                if (board[v][idx] == '.') {
                    set.remove(vv)
                    if (set.size == 1) {
                        left--
                        queue.add(idx to v)
                        hmap[idx].remove(v)
                        bmap[(v / 3) * 3 + idx / 3].remove((v % 3) * 3 + idx % 3)
                        board[v][idx] = '0' + set.single()
                    }
                }
            }

            for ((idx, set) in bmap[(v/3)*3 + h/3]) {
                val hb = (h/3)*3 + idx%3
                val vb = (v/3)*3 + idx/3
                if (board[vb][hb] == '.') {
                    set.remove(vv)
                    if (set.size == 1) {
                        left--
                        queue.add(hb to vb)
                        hmap[hb].remove(vb)
                        vmap[vb].remove(hb)
                        board[vb][hb] = '0' + set.single()
                    }
                }
            }
        }
    }
}

fun main() {
    val board = arrayOf(
            charArrayOf('.','.','9','7','4','8','.','.','.'),charArrayOf('7','.','.','.','.','.','.','.','.'),charArrayOf('.','2','.','1','.','9','.','.','.'),charArrayOf('.','.','7','.','.','.','2','4','.'),charArrayOf('.','6','4','.','1','.','5','9','.'),charArrayOf('.','9','8','.','.','.','3','.','.'),charArrayOf('.','.','.','8','.','3','.','2','.'),charArrayOf('.','.','.','.','.','.','.','.','6'),charArrayOf('.','.','.','2','7','5','9','.','.')
    )

    Solution37().solveSudoku(board)
    println(board.map { it.joinToString("") })
}