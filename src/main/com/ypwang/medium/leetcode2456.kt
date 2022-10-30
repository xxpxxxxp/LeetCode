package com.ypwang.medium

class Solution2456 {
    fun mostPopularCreator(creators: Array<String>, ids: Array<String>, views: IntArray): List<List<String>> {
        val cs = creators.zip(ids.zip(views.toList()))
            .groupBy { it.first }
            .mapValues {
                it.value.map {t -> t.second.second }.sum() to
                        it.value.map { t -> t.second }
            }

        val min = cs.map { it.value.first }.max()!!
        return cs.filter { it.value.first == min }.map {
            listOf(it.key, it.value.second.minWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }).first) }
    }
}