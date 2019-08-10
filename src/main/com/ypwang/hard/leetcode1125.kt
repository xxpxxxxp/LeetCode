package com.ypwang.hard

class Solution1125 {
    fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {
        val map = req_skills.withIndex().map { it.value to it.index }.toMap()
        val p = people.map { it.map { i -> 1 shl map[i]!! }.let { l -> if (l.isEmpty()) 0 else l.reduce { a, b -> a or b } } }.toIntArray()

        val cache = mutableMapOf<Int, List<Int>>()
        fun helper(need: Int): List<Int> {
            if (need == 0) return listOf()
            if (need !in cache) {
                cache[need] = p.withIndex().filter { it.value and need > 0 }
                    .map { helper(need and (it.value and need).inv()) + it.index }
                    .minBy { it.size }!!
            }
            return cache[need]!!
        }

        return helper((1 shl req_skills.size) - 1).toIntArray()
    }
}

fun main() {
    println(Solution1125().smallestSufficientTeam(arrayOf("mmcmnwacnhhdd","vza","mrxyc"), listOf(
            listOf("mmcmnwacnhhdd"),listOf(),listOf(),listOf("vza","mrxyc")
    )).toList())
}