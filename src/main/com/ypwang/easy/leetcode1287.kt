package com.ypwang.easy

class Solution1287 {
    fun findSpecialInteger(arr: IntArray): Int {
        val cnt = mutableMapOf<Int, Int>()

        for (i in arr) {
            cnt[i] = cnt.getOrDefault(i, 0) + 1

            if (cnt.size == 4) {
                val removal = mutableSetOf<Int>()
                for (k in cnt.keys) {
                    if (cnt[k]!! == 1) removal.add(k)
                    else cnt[k] = cnt[k]!! - 1
                }

                removal.forEach { cnt.remove(it) }
            }
        }

        return cnt.maxByOrNull { it.value }!!.key
    }
}