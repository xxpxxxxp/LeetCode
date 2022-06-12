package com.ypwang.hard

class Solution2306 {
    fun distinctNames(ideas: Array<String>): Long {
        val map = mutableMapOf<Int, MutableSet<String>>()
        for (i in 0..25)
            map[i] = mutableSetOf()

        for (i in ideas.indices)
            map[ideas[i][0] - 'a']!!.add(ideas[i].substring(1))

        var res = 0L
        for (i in 0..25) {
            for (j in i + 1..25) {
                val setA = map[i]!!
                val setB = map[j]!!
                val unionSet = setA.union(setB)
                res += 2L * (unionSet.size - setA.size) * (unionSet.size - setB.size)
            }
        }
        return res
    }
}