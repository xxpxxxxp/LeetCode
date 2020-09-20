package com.ypwang.medium

class Solution1593 {
    fun maxUniqueSplit(s: String): Int {
        fun backtrace(i: Int, set: MutableSet<String>): Int {
            if (i == s.length) return set.size

            var len = Int.MIN_VALUE
            for (j in i+1 .. s.length) {
                val sb = s.substring(i, j)
                if (sb !in set) {
                    set.add(sb)
                    len = maxOf(len, backtrace(j, set))
                    set.remove(sb)
                }
            }

            return len
        }

        return backtrace(0, mutableSetOf())
    }
}