package com.ypwang.medium

class Solution3568 {
    data class Quad(val r: Int, val c: Int, val energy: Int, val mask: Int)

    fun minMoves(classroom: Array<String>, energy: Int): Int {
        val dr = intArrayOf(-1, 1, 0, 0)
        val dc = intArrayOf(0, 0, -1, 1)

        val R = classroom.size
        val C = classroom[0].length

        var startR = -1
        var startC = -1
        val litterCoords = mutableListOf<Pair<Int, Int>>()
        val litterCoordToIdx = mutableMapOf<Pair<Int, Int>, Int>()

        for (i in 0 until R) {
            for (j in 0 until C) {
                when (classroom[i][j]) {
                    'S' -> {
                        startR = i
                        startC = j
                    }
                    'L' -> {
                        litterCoordToIdx[i to j] = litterCoords.size
                        litterCoords.add(i to j)
                    }
                }
            }
        }

        val numLitter = litterCoords.size
        if (numLitter == 0)
            return 0

        val targetMask = (1 shl numLitter) - 1

        val dist = Array(R) {
            Array(C) {
                Array(energy + 1) {
                    IntArray(1 shl numLitter) { -1 }
                }
            }
        }

        val queue: ArrayDeque<Quad> = ArrayDeque()
        dist[startR][startC][energy][0] = 0
        queue.add(Quad(startR, startC, energy, 0))

        while (queue.isNotEmpty()) {
            val (r, c, currentE, mask) = queue.removeFirst()
            val moves = dist[r][c][currentE][mask]

            if (mask == targetMask)
                return moves

            for (i in 0..3) {
                val nr = r + dr[i]
                val nc = c + dc[i]

                if (nr in 0 until R && nc in 0 until C && classroom[nr][nc] != 'X') {
                    if (currentE > 0) {
                        val energyAfterMove = currentE - 1
                        val nextTotalMoves = moves + 1
                        var energyAtNewCell = energyAfterMove
                        var newMask = mask
                        val destChar = classroom[nr][nc]

                        if (destChar == 'L') {
                            val litterIdx = litterCoordToIdx[nr to nc]!!
                            newMask = newMask or (1 shl litterIdx)
                        }

                        if (destChar == 'R') {
                            energyAtNewCell = energy
                        }

                        if (dist[nr][nc][energyAtNewCell][newMask] == -1 ||
                            nextTotalMoves < dist[nr][nc][energyAtNewCell][newMask]) {
                            dist[nr][nc][energyAtNewCell][newMask] = nextTotalMoves
                            queue.add(Quad(nr, nc, energyAtNewCell, newMask))
                        }
                    }
                }
            }
        }

        return -1
    }
}
