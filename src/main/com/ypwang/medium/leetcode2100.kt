package com.ypwang.medium

class Solution00 {
    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        val positiveSet = mutableListOf<Int>()
        var cnt = 0
        for (i in 0 until security.size) {
            if (i > 0)
                if (security[i-1] >= security[i])
                    cnt++
                else
                    cnt = 0

            if (cnt >= time)
                positiveSet.add(i)
        }

        val negativeSet = mutableSetOf<Int>()
        cnt = 0
        for (i in security.lastIndex downTo 0) {
            if (i < security.lastIndex)
                if (security[i+1] >= security[i])
                    cnt++
                else
                    cnt = 0

            if (cnt >= time)
                negativeSet.add(i)
        }

        return positiveSet.intersect(negativeSet).toList()
    }
}