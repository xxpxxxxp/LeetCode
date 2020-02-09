package com.ypwang.hard

class Solution1345 {
    fun minJumps(arr: IntArray): Int {
        val map = arr.withIndex().groupBy { it.value }.map { it.key to it.value.map { kv -> kv.index } }.toMap()

        val visited = BooleanArray(arr.size)
        var queue = listOf(0)
        visited[0] = true

        var count = 0
        while (true) {
            val next = mutableListOf<Int>()

            for (idx in queue) {
                if (idx == arr.lastIndex) return count
                if (idx > 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true
                    next.add(idx - 1)
                }
                if (idx + 1 < arr.size && !visited[idx + 1]) {
                    visited[idx + 1] = true
                    next.add(idx + 1)
                }
                map[arr[idx]]!!.filter { !visited[it] }.forEach {
                    visited[it] = true
                    next.add(it)
                }
            }

            queue = next
            count++
        }
    }
}