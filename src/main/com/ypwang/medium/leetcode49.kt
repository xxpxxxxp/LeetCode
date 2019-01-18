package com.ypwang.medium

class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.map { Pair(it.groupBy { c -> c }.mapValues { c -> c.value.size }, it) }
                .groupBy { it.first }.map { it.value.map { i -> i.second } }
    }
}