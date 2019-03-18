package com.ypwang.medium

class Solution93 {
    fun restoreIpAddresses(s: String): List<String> {
        val cache = mutableMapOf<Pair<Int, String>, List<String>>()

        fun split(count: Int, remain: String): List<String> {
            if (count == 1) {
                try {
                    if (remain.length < 4 && (remain.length == 1 || !remain.startsWith('0')) && remain.toInt() < 256)
                        return listOf(remain)
                } catch (e :NumberFormatException) {
                }
                return listOf()
            }

            val rst = mutableListOf<String>()

            if (!remain.isEmpty()) {
                rst.addAll(split(count-1, remain.drop(1)).map { "${remain.first()}.$it" })

                if (remain.length > 2 && !remain.startsWith('0')) {
                    rst.addAll(split(count-1, remain.drop(2)).map { "${remain.take(2)}.$it" })
                }
                if (remain.length > 3 && !remain.startsWith('0')) {
                    val c = remain.take(3).toInt()
                    if (c < 256) {
                        rst.addAll(split(count-1, remain.drop(3)).map { "${remain.take(3)}.$it" })
                    }
                }
            }

            cache[Pair(count, remain)] = rst
            return rst
        }

        return split(4, s)
    }
}

fun main(args: Array<String>) {
    println(Solution93().restoreIpAddresses("010010"))
}