package com.ypwang.medium

class Solution1817 {
    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val rst = IntArray(k)

        logs.groupBy { it[0] }
            .map { it.value.map { arr -> arr[1] }.toSet().size }
            .forEach { rst[it-1]++ }

        return rst
    }
}