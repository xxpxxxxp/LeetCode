package com.ypwang.medium

class Solution1140 {
    fun stoneGameII(piles: IntArray): Int {
        val cache = mutableMapOf<Int, Int>()

        // start from idx, if I take the first turn, and I could take max to take piles
        // the maximum stones I could take
        fun helper(idx: Int, take: Int, left: Int): Int {
            val hash = (take shl 13) + idx

            if (hash !in cache) {
                if (idx + 2*take >= piles.size) {
                    cache[hash] = left
                } else {
                    var sum = 0
                    var l = left
                    var max = 0

                    for (i in 0 until 2*take) {
                        sum += piles[idx + i]
                        l -= piles[idx + i]
                        val other = helper(idx+i+1, maxOf(take, i+1), l)
                        if (sum + l - other > max) {
                            max = sum + l - other
                        }
                    }

                    cache[hash] = max
                }
            }

            //println("from $idx take $take could max take ${cache[hash]!!}")
            return cache[hash]!!
        }

        return helper(0, 1, piles.sum())
    }
}

fun main() {
    println(Solution1140().stoneGameII(intArrayOf(2,7,9,4,4)))
}