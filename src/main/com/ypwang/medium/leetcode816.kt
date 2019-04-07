package com.ypwang.medium

class Solution816 {
    private fun checkPre(s: String): Boolean = s.length == 1 || !s.startsWith('0')

    private fun checkPost(s: String): Boolean = !s.endsWith('0')

    fun pointBreak(s: String): List<String> {
        val rst = mutableListOf<String>()

        if  (checkPre(s))
            rst.add(s)

        if (s.all { it == '0' })
            return rst

        for (i in 1 until s.length) {
            val pre = s.substring(0, i)
            val post = s.substring(i)

            if (checkPre(pre) && checkPost(post))
                rst.add("$pre.$post")
        }

        return rst
    }

    fun ambiguousCoordinates(S: String): List<String> {
        val rst = mutableListOf<String>()

        val s = S.substring(1, S.lastIndex)
        for (i in 1 until s.length) {
            val before = s.substring(0, i)
            val after = s.substring(i)

            val bp = pointBreak(before)
            if (bp.any()) {
                val ap = pointBreak(after)

                for (b in bp) {
                    for (a in ap) {
                        rst.add("($b, $a)")
                    }
                }
            }
        }

        return rst
    }
}

fun main() {
    println(Solution816().ambiguousCoordinates("(100)"))
}