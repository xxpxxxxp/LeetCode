package com.ypwang.medium

class Solution207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val pre = prerequisites.map { Pair(it[0], it[1]) }
                .groupBy { it.first }.mapValues { it.value.map { i -> i.second } }

        val visited = mutableSetOf<Int>()
        val stack = Array(numCourses) { false }

        fun dfs(course: Int): Boolean {
            if (course in visited) {
                return true
            }

            if (stack[course]) {
                return false
            }

            stack[course] = true

            val rst = pre[course]?.all { dfs(it) } ?: true

            stack[course] = false

            return rst
        }

        for (i in 0 until numCourses) {
            if (i in visited) {
                continue
            }

            if (!dfs(i)) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Solution207().canFinish(2, arrayOf(intArrayOf(1,0))))
}