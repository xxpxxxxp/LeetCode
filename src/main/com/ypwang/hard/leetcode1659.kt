package com.ypwang.hard

class Solution1659 {
    fun getMaxGridHappiness(m: Int, n: Int, introvertsCount: Int, extrovertsCount: Int): Int {
        val dp = mutableMapOf<Int, Int>()

        // pos: i * n + j   [0,25]
        // introvert left: il   [0,6]
        // extrovert left: el   [0,6]
        // introvert mask: im   [0, 2 << 6]
        // extrovert mask: em   [0, 2 << 6]
        fun solve(pos: Int, il: Int, el: Int, im: Int, em: Int): Int {
            if (pos == m * n)
                return 0

            // 0 ... 4  5 ... 7     8 ... 10    11 ... 16   17 ... 22
            //   pos      il           el           im          em
            val mask = pos or (il shl 5) or (el shl 8) or (im shl 11) or (em shl 17)
            if (mask !in dp) {
                val nim = (im * 2) and 0x3f
                val nem = (em * 2) and 0x3f

                // nobody seat
                var max = solve(pos+1, il, el, nim, nem)

                // if seat, how many neighbor
                var neighbor = 0
                var increase = 0

                if (pos / n > 0) {
                    val upMask = 1 shl n
                    if (nim and upMask != 0) {
                        increase -= 30
                        neighbor++
                    }

                    if (nem and upMask != 0) {
                        increase += 20
                        neighbor++
                    }
                }

                if (pos % n > 0) {
                    if (nim and 2 != 0) {
                        increase -= 30
                        neighbor++
                    }

                    if (nem and 2 != 0) {
                        increase += 20
                        neighbor++
                    }
                }

                if (il > 0) {
                    // seat an introvert
                    max = maxOf(max,
                            120 - 30 * neighbor + increase + solve(pos+1, il-1, el, nim+1, nem)
                    )
                }

                if (el > 0) {
                    // seat an extrovert
                    max = maxOf(max,
                            40 + 20 * neighbor + increase + solve(pos+1, il, el-1, nim, nem+1)
                    )
                }

                dp[mask] = max
            }

            return dp[mask]!!
        }

        return solve(0, introvertsCount, extrovertsCount, 0, 0)
    }
}

fun main() {
    println(Solution1659().getMaxGridHappiness(5,4,6,3))
    println(Solution1659().getMaxGridHappiness(2,3,1,2))
    println(Solution1659().getMaxGridHappiness(3,1,2,1))
    println(Solution1659().getMaxGridHappiness(2,2,4,0))
}