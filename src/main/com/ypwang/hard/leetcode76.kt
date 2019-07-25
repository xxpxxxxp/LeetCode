package com.ypwang.hard

class Solution76 {
    fun minWindow(s: String, t: String): String {
        val map = t.groupBy { it }.mapValues { it.value.size }
        val mut = map.toMutableMap()    // holes
        val slicing = mutableMapOf<Char, Int>()     // running slice

        var i = 0
        var j = 0

        var si = 0
        var sj = Int.MAX_VALUE
        while (j < s.length) {
            while (mut.isEmpty()) {     // no holes
                if (j - i < sj - si) {
                    si = i
                    sj = j
                }

                val tmp = i++
                if (s[tmp] in slicing) {
                    slicing[s[tmp]] = slicing[s[tmp]]!! - 1
                    if (slicing[s[tmp]]!! < map[s[tmp]]!!) {
                        mut[s[tmp]] = 1
                        break
                    }
                }
            }

            if (s[j] in mut) {
                mut[s[j]] = mut[s[j]]!! - 1
                if (mut[s[j]] == 0)
                    mut.remove(s[j])
            }
            if (s[j] in map) {
                slicing[s[j]] = slicing.getOrDefault(s[j], 0) + 1
            }

            j++
        }

        if (mut.isEmpty()) {
            while (true) {
                if (s[i] !in slicing) i++
                else {
                    slicing[s[i]] = slicing[s[i]]!! - 1
                    if (slicing[s[i]]!! < map[s[i]]!!)
                        break
                    i++
                }
            }

            if (j - i < sj - si) {
                si = i
                sj = j
            }
        }


        return if (sj == Int.MAX_VALUE) "" else s.substring(si, sj)
    }
}