package com.ypwang.medium

class Solution2491 {
    fun dividePlayers(skill: IntArray): Long {
        val sum = skill.sum()
        if (sum % (skill.size / 2) != 0)
            return -1

        val div = sum / (skill.size / 2)
        val cnt = skill.groupBy { it }.mapValues { it.value.size }.toMap().toMutableMap()

        var rst = 0L
        for ((k, v) in cnt) {
            if (v == 0)
                continue

            if (cnt.getOrDefault(div - k, 0) != v)
                return -1

            cnt[k] = 0
            if (k == div - k) {
                if (v % 2 != 0)
                    return -1

                rst += k.toLong() * (div - k) * (v / 2)
            } else {
                rst += k.toLong() * (div - k) * v
                cnt[div - k] = cnt[div - k]!! - v
            }
        }

        return rst
    }
}

fun main() {
    println(Solution2491().dividePlayers(intArrayOf(3,2,5,1,3,4)))
}