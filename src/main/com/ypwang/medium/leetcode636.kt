package com.ypwang.medium

class Solution636 {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val rst = IntArray(n){0}
        val stack = mutableListOf<Int>()

        var cur = 0
        for (log in logs) {
            val (thread, type, time) = log.split(':')
            val threadid = thread.toInt()
            val timet = time.toInt()

            when (type) {
                "start" -> {
                    if (!stack.isEmpty()) {
                        rst[stack.last()] += (timet - cur)
                    }
                    stack.add(threadid)
                    cur = timet
                }
                "end" -> {
                    rst[threadid] += (timet - cur + 1)
                    stack.removeAt(stack.lastIndex)
                    cur = timet + 1
                }
            }
        }
        return rst
    }
}

fun main(args: Array<String>) {
    println(Solution636().exclusiveTime(2, listOf("0:start:0",
            "1:start:2",
            "1:end:5",
            "0:end:6")).toList())
}