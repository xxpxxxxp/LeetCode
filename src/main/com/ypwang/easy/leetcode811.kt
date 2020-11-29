package com.ypwang.easy

class Solution811 {
    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        fun extract(it: String): List<Pair<String, Int>> {
            val sp = it.split(' ')
            val count = sp[0].toInt()
            var full = sp[1]
            val rst = mutableListOf<Pair<String, Int>>()
            while (true) {
                rst.add(Pair(full, count))
                val p = full.indexOfFirst{ c -> c == '.'}
                if (p == -1) {
                    break
                }
                full = full.substring(p+1)
            }
            return rst
        }

        return cpdomains.flatMap{ extract(it) }.groupBy { it.first }.map { "${it.value.sumBy { p -> p.second }} ${it.key}" }
    }
}

fun main() {
    println(Solution811().subdomainVisits(arrayOf("9001 discuss.leetcode.com")))
}