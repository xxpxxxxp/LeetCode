package com.ypwang.easy

class Solution3823 {
    fun reverseByType(s: String): String {
        val (letters, others) = s.withIndex().partition { it.value.isLetter() }
        val sb = CharArray(s.length)
        letters.let {
            val idx = it.map { kv -> kv.index }
            val v = it.map { kv -> kv.value }.reversed()
            for ((i, c) in idx.zip(v))
                sb[i] = c
        }
        others.let {
            val idx = it.map { kv -> kv.index }
            val v = it.map { kv -> kv.value }.reversed()
            for ((i, c) in idx.zip(v))
                sb[i] = c
        }

        return String(sb)
    }
}
