package com.ypwang.medium

class Solution1497 {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val mods = arr.map { (it % k + k) % k }
                .groupBy { it }
                .mapValues { it.value.size }

        for ((m, v) in mods) {
            if (m == 0 || 2 * m == k) {
                if (v % 2 != 0)
                    return false
            }
            else if (m < k / 2 && mods.getOrDefault(k - m, 0) != v) return false
        }

        return true
    }
}

fun main() {
    println(Solution1497().canArrange(intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9), 5))
}
