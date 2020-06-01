package com.ypwang.medium

class Solution1461 {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val all = mutableSetOf<String>()

        val sb = StringBuilder()
        sb.append(s.take(k))
        all.add(sb.toString())

        for (i in k until s.length) {
            sb.deleteCharAt(0)
            sb.append(s[i])
            all.add(sb.toString())
        }

        return all.size == 1 shl k
    }
}