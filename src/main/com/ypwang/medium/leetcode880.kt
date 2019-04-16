package com.ypwang.medium

import java.lang.StringBuilder
import java.util.*

class Solution880 {
    fun decodeAtIndex(S: String, K: Int): String {
        val stack = Stack<Pair<String, Int>>()

        var count = 0
        var cur = StringBuilder()
        for (c in S) {
            if (c.isDigit()) {
                val t = c - '0'
                val s = cur.toString()

                if ((K + t - 1) / t <= count) {
                    var idx = (K-1) % count
                    count -= s.length
                    if (idx >= count) return s[idx - count].toString()
                    while (true) {
                        val last = stack.pop()
                        count /= last.second
                        idx %= count
                        count -= last.first.length
                        if (idx >= count)
                            return last.first[idx - count].toString()
                    }
                }

                stack.add(s to t)
                count *= t
                cur = StringBuilder()
            } else {
                cur.append(c)
                count += 1
                if (count == K) return c.toString()
            }
        }

        return ""
    }
}

fun main() {
    println(Solution880().decodeAtIndex("yyuele72uthzyoeut7oyku2yqmghy5luy9qguc28ukav7an6a2bvizhph35t86qicv4gyeo6av7gerovv5lnw47954bsv2xruaej",1233656269))
//    println(Solution880().decodeAtIndex("a2b3c4d5e6f7g8h9",9))
//    println(Solution880().decodeAtIndex("a23", 6))
//    println(Solution880().decodeAtIndex("leet2code3",10))
//    println(Solution880().decodeAtIndex("ha22",5))
//    println(Solution880().decodeAtIndex("a2345678999999999999999",1))
//    println(Solution880().decodeAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp",976159153))
}