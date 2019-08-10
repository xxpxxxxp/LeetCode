package com.ypwang.hard

class Solution403 {
    fun canCross(stones: IntArray): Boolean {
        if (stones[1] - stones[0] != 1) return false
        if (stones.size == 2) return true
        val mapping = mutableMapOf(1 to mutableSetOf(1))

        for (i in 1 until stones.size) {
            if (i in mapping) {
                val available = mapping[i]!!
                val max = available.max()!!

                var j = i+1
                while (j < stones.size && stones[j] - stones[i] <= max+1) {
                    val diff = stones[j] - stones[i]
                    if (diff in available || diff-1 in available || diff+1 in available) {
                        if (j == stones.lastIndex) return true
                        if (j !in mapping) mapping[j] = mutableSetOf()
                        mapping[j]!!.add(diff)
                    }
                    j++
                }

                mapping.remove(i)
            }
        }

        return false
    }
}

fun main() {
    println(Solution403().canCross(intArrayOf(0,1,2,3,4,8,9,11)))
}