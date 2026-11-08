package com.ypwang.medium

import java.util.Stack

class Solution4103 {
    fun canRemoveAll(types: IntArray, colors: IntArray, groupSize: IntArray): Boolean {
        val s = Stack<IntArray>()
        for (i in types.indices) {
            val t = types[i]
            val c = colors[i]
            if (s.isNotEmpty() && s.peek()[0] == t && s.peek()[1] == c)
                s.peek()[2] = s.peek()[2] + 1
            else
                s.push(intArrayOf(t, c, 1))

            if (s.peek()!![2] == groupSize[t])
                s.pop()
        }
        return s.isEmpty()
    }
}
