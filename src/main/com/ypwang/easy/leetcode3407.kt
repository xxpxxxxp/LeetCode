package com.ypwang.easy

class Solution3407 {
    fun hasMatch(s: String, p: String): Boolean {
        val idx = p.indexOf('*')
        val pre = s.indexOf(p.substring(0, idx))
        if (pre == -1)
            return false
        val post = p.substring(idx+1).let { if (it.isEmpty()) s.length else s.lastIndexOf(it) }
        if (post == -1)
            return false

        return pre + idx <= post
    }
}

fun main() {
    println(Solution3407().hasMatch("xks", "s*"))
    println(Solution3407().hasMatch("l", "*"))
}
