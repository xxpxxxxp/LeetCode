package com.ypwang.easy

class Solution1002 {
    fun commonChars(A: Array<String>): List<String> =
        A.map { it.groupBy { c -> c }.mapValues { it.value.size } }.reduce { ma, mb ->
            ma.filter { it.key in mb }.map { it.key to minOf(it.value, mb[it.key]!!) }.toMap()
        }.flatMap { m -> List(m.value) { m.key.toString() }  }
}