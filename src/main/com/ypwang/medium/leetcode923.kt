package com.ypwang.medium

class Solution923 {
    fun threeSumMulti(A: IntArray, target: Int): Int {
        val mod = 1000000007

        val m = A.groupBy { it }.mapValues { it.value.size }

        var count = 0L
        for (i in m.filter { it.value >= 3 && 3 * it.key == target }) {
            count = (count + (i.value.toLong() * (i.value - 1) / 2 % mod) * (i.value - 2) / 3 % mod) % mod
        }

        for (i in m.filter { it.value >= 2 && 3 * it.key != target }) {
            count = (count + m.getOrDefault(target - 2 * i.key, 0) * i.value * (i.value - 1) / 2) % mod
        }

        var c = 0L
        val t = m.toList().sortedBy { it.first }.toTypedArray()
        for (i in 0 until t.size - 1) {
            for (j in i+1 until t.size) {
                if (2 * t[j].first >= target - t[i].first) break
                val another = target - t[i].first - t[j].first
                if (another != t[i].first && another != t[j].first && another in m)
                    c = (c + t[i].second * t[j].second * m[another]!!) % mod
            }
        }

        return (count + c).toInt()
    }
}

fun main() {
    val t = IntArray(3000){0}
    println(Solution923().threeSumMulti(t, 0))
}