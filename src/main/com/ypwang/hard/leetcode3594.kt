package com.ypwang.hard

import java.util.PriorityQueue
import kotlin.math.floor

class Solution3594 {
    fun minTime(n: Int, k: Int, m: Int, time: IntArray, mul: DoubleArray): Double {
        data class State(val t: Double, val p: Int, val mask: Int, val j: Int)

        val heap = PriorityQueue<State>(compareBy { it.t })
        heap.add(State(0.0, 0, 0, 0))

        val seen = mutableMapOf<Triple<Int, Int, Int>, Double>()
        val fullMask = (1 shl n) - 1

        while (heap.isNotEmpty()) {
            val (t, p, mask, j) = heap.poll()
            val stateKey = Triple(p, mask, j)

            if (stateKey in seen && seen[stateKey]!! <= t)
                continue
            seen[stateKey] = t

            if (mask == fullMask && p == 1)
                return String.format("%.5f", t).toDouble()

            if (p == 0) {
                val camp = (0 until n).filter { (mask shr it) and 1 == 0 }
                for (r in 1..minOf(k, camp.size)) {
                    val groupComb = combinations(camp, r)
                    for (group in groupComb) {
                        val cross = group.maxOf { time[it] } * mul[j]
                        val newJ = ((j + floor(cross)).toInt()) % m
                        var newMask = mask
                        for (i in group) {
                            newMask = newMask or (1 shl i)
                        }
                        heap.add(State(t + cross, 1, newMask, newJ))
                    }
                }
            } else {
                val dst = (0 until n).filter { (mask shr it) and 1 == 1 }
                for (i in dst) {
                    val returnTime = time[i] * mul[j]
                    val newJ = ((j + floor(returnTime)).toInt()) % m
                    val newMask = mask and (1 shl i).inv()
                    heap.add(State(t + returnTime, 0, newMask, newJ))
                }
            }
        }

        return -1.0
    }

    // Helper function to generate combinations
    private fun <T> combinations(list: List<T>, r: Int): List<List<T>> {
        val result = mutableListOf<List<T>>()

        fun backtrack(start: Int, curr: MutableList<T>) {
            if (curr.size == r) {
                result.add(ArrayList(curr))
                return
            }
            for (i in start until list.size) {
                curr.add(list[i])
                backtrack(i + 1, curr)
                curr.removeAt(curr.size - 1)
            }
        }

        backtrack(0, mutableListOf())
        return result
    }
}
