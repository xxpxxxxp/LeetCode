package com.ypwang.medium

class Solution609 {
    fun hash(s: String): Int {
        var rst = 0
        for (c in s) {
           rst = (c.toInt() + 11 * rst) % Int.MAX_VALUE
        }
        return rst
    }

    fun findDuplicate(paths: Array<String>): List<List<String>> {
        return paths.flatMap { d ->
            val all = d.split(' ')
            val dir = all[0]
            val rst = mutableListOf<Pair<String, Int>>()
            for (i in 1 until all.size) {
                val p = all[i].split("(", ")")
                assert(p.size == 2)
                rst.add(Pair(dir + "/" + p[0], hash(p[1])))
            }
            rst
        }.groupBy { it.second }.filter { it.value.size > 1 }.map { it.value.map { p -> p.first } }
    }
}

fun main(args: Array<String>) {
    println(Solution609().findDuplicate(arrayOf(
            "root/a 1.txt(FB) 2.txt(a)","root/c 3.txt(Ea)","root/c/d 4.txt(b)","root 4.txt(c)"
    )))
}