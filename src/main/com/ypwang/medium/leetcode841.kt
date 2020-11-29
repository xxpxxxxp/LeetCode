package com.ypwang.medium

class Solution841 {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = mutableSetOf(0)
        val next = rooms[0].toMutableSet()

        while (next.isNotEmpty()) {
            val n = next.first()
            next.remove(n)
            visited.add(n)
            next.addAll(rooms[n].minus(visited))
        }

        return visited.size == rooms.size
    }
}

fun main() {
    println(Solution841().canVisitAllRooms(listOf(
            listOf(1), listOf(2), listOf(3), listOf()
    )))
}