package com.ypwang.medium

import java.util.*

class Solution1487 {
    fun getFolderNames(names: Array<String>): Array<String> {
        val map = HashMap<String, Int>()
        val res = mutableListOf<String>()
        for (i in names.indices) {
            res.add(
                if (map.containsKey(names[i])) {
                    var `val` = map[names[i]]!!
                    var sb = StringBuilder(names[i])
                    sb.append('(')
                    sb.append(`val`)
                    sb.append(')')
                    while (map.containsKey(sb.toString())) {
                        `val`++
                        sb = StringBuilder(names[i])
                        sb.append('(')
                        sb.append(`val`)
                        sb.append(')')
                    }
                    map[sb.toString()] = 1
                    map[names[i]] = `val`!! + 1
                    sb.toString()
                } else {
                    map[names[i]] = 1
                    names[i]
                }
            )
        }
        return res.toTypedArray()
    }
}