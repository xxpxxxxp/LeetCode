package com.ypwang.medium

class Solution2284 {
    fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
        val m = senders.toSet().associateWith { 0 }.toMutableMap()
        for ((ms, s) in messages.zip(senders)) {
            m[s] = m.getOrDefault(s, 0) + ms.split(' ').count()
        }

        var c = 0
        var s = ""
        for ((k, v) in m) {
            if (v > c) {
                c = v
                s = k
            } else if (v == c && k > s) {
                s = k
            }
        }

        return s
    }
}