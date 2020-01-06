package com.ypwang.medium

import java.util.*

class Solution1306 {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val visited = BooleanArray(arr.size)
        val bfs: Queue<Int> = LinkedList()
        bfs.add(start)

        while (bfs.isNotEmpty()) {
            val n = bfs.poll()
            if (arr[n] == 0) return true
            visited[n] = true

            if (n + arr[n] in arr.indices && !visited[n + arr[n]]) bfs.offer(n + arr[n])
            if (n - arr[n] in arr.indices && !visited[n - arr[n]]) bfs.offer(n - arr[n])
        }

        return false
    }
}