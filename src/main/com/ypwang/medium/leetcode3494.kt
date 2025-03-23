package com.ypwang.medium

class Solution3494 {
    fun minTime(skill: IntArray, mana: IntArray): Long {
        val done = LongArray(skill.size + 1)

        for (j in mana.indices) {
            for (i in skill.indices)
                done[i + 1] = maxOf(done[i + 1], done[i]) + mana[j].toLong() * skill[i]
            for (i in skill.size - 1 downTo 1)
                done[i] = done[i + 1] - mana[j].toLong() * skill[i]
        }
        return done.last()
    }
}

fun main() {
    println(Solution3494().minTime(intArrayOf(1,5,2,4), intArrayOf(5,1,4,2)))
}
