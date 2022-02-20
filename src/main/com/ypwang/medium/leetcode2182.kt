package com.ypwang.medium

class Solution2182 {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val counter = s.groupBy { it }.mapValues { it.value.size }.toList().sortedByDescending { it.first }.toMutableList()
        val buf = StringBuffer()

        var c = 0
        while (counter.isNotEmpty()) {
            val (char, n) = counter.first()
            buf.append(char)

            if (n == 1) {
                counter.removeAt(0)
                c = 0
            } else {
                counter[0] = char to n-1
                if (++c == repeatLimit) {
                    if (counter.size > 1) {
                        val (c1, n1) = counter[1]
                        buf.append(c1)
                        if (n1 == 1)
                            counter.removeAt(1)
                        else
                            counter[1] = c1 to n1-1
                    } else
                        return buf.toString()

                    c = 0
                }
            }
        }

        return buf.toString()
    }
}