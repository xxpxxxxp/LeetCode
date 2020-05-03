package com.ypwang.easy

class Solution1436 {
    fun destCity(paths: List<List<String>>): String =
        paths.fold(mutableSetOf<String>() to mutableSetOf<String>()){ (sA, sB), (A, b) ->
            sA.add(A)
            sB.add(b)
            sA to sB
        }.let { it.second.subtract(it.first).single() }
}