package com.ypwang.easy

class Solution1189 {
    fun maxNumberOfBalloons(text: String): Int {
        val count = IntArray(26)

        for (c in text) {
            count[c - 'a']++
        }

        return listOf(count['b'-'a'], count[0], count['l'-'a']/2, count['o'-'a']/2, count['n'-'a']).min()!!
    }
}