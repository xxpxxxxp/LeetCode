package com.ypwang.medium

class Solution1282 {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val rst = mutableListOf<List<Int>>()
        val map = mutableMapOf<Int, MutableList<Int>>()

        groupSizes.withIndex().forEach { (i, v) ->
            if (v == 1) rst.add(listOf(i))
            else if (v !in map) map[v] = mutableListOf(i)
            else {
                map[v]!!.add(i)
                if (map[v]!!.size == v) {
                    rst.add(map[v]!!)
                    map.remove(v)
                }
            }
        }

        return rst
    }
}