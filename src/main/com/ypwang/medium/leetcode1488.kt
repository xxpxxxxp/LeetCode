package com.ypwang.medium

class Solution1488 {
    fun avoidFlood(rains: IntArray): IntArray {
        val rst = IntArray(rains.size)
        val seen = mutableMapOf<Int, Int>()
        val holes = mutableListOf<Int>()

        for ((i, r) in rains.withIndex()) {
            if (r == 0)
                holes.add(i)
            else {
                if (r in seen) {
                    val idx = holes.binarySearch(seen[r]!!).let { -it - 1 }
                    if (idx == holes.size)
                        return intArrayOf()

                    rst[holes[idx]] = r
                    holes.removeAt(idx)
                }

                seen[r] = i
                rst[i] = -1
            }
        }

        val f = rains.first { it > 0 }
        holes.forEach { rst[it] = f }
        return rst
    }
}

fun main() {
    println(Solution1488().avoidFlood(intArrayOf(0,1,1)).toList())
    println(Solution1488().avoidFlood(intArrayOf(1,2,0,0,2,1)).toList())
}