package com.ypwang.medium

class Solution1311 {
    fun watchedVideosByFriends(watchedVideos: List<List<String>>, friends: Array<IntArray>, id: Int, level: Int): List<String> {
        val seenFriends = mutableListOf<Int>()
        var f = setOf(id)

        for (i in 0 until level) {
            seenFriends.addAll(f)
            f = f.flatMap { friends[it].toList() }.toSet().subtract(seenFriends)
        }

        return f.flatMap { watchedVideos[it] }
                .groupBy { it }
                .mapValues { it.value.size }
                .toList()
                .sortedWith(Comparator { kv1, kv2 ->
                    if (kv1.second != kv2.second) kv1.second.compareTo(kv2.second)
                    else kv1.first.compareTo(kv2.first)
                })
                .map { it.first }
    }
}

fun main() {
    println(Solution1311().watchedVideosByFriends(listOf(
            listOf("A", "B"), listOf("C"), listOf("B", "C"), listOf("D")
    ), arrayOf(intArrayOf(1,2), intArrayOf(0,3), intArrayOf(0,3), intArrayOf(1,2)), 0, 1))
    println(Solution1311().watchedVideosByFriends(listOf(
            listOf("A", "B"), listOf("C"), listOf("B", "C"), listOf("D")
    ), arrayOf(intArrayOf(1,2), intArrayOf(0,3), intArrayOf(0,3), intArrayOf(1,2)), 0, 2))
}