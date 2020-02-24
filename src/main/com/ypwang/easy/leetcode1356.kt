package com.ypwang.easy

class Solution1356 {
    fun sortByBits(arr: IntArray): IntArray {
        val bucks = Array<MutableList<Int>?>(32){ null }
        for (i in arr) {
            val t = i.toString(2).count { it == '1' }
            if (bucks[t] == null) bucks[t] = mutableListOf()
            bucks[t]!!.add(i)
        }

        return bucks.filterNotNull().flatMap { it!!.sorted() }.toIntArray()
    }
}