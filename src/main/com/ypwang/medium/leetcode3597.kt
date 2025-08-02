package com.ypwang.medium

class Solution3597 {
    fun partitionString(s: String): List<String> {
        val set = mutableSetOf<String>()
        val list = mutableListOf<String>()
        var it = 0
        while (it < s.length) {
            val temp = StringBuilder()
            var j = it
            while (j < s.length) {
                temp.append(s[j++])
                if (temp.toString() !in set) {
                    set.add(temp.toString())
                    list.add(temp.toString())
                    break
                }
            }
            it = j
        }
        return list
    }
}
