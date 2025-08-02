package com.ypwang.medium

import java.util.*

class Solution3433 {
    fun countMentions(numberOfUsers: Int, events: List<List<String>>): List<Int> {
        val ans = IntArray(numberOfUsers) { 0 }
        val userStatus = IntArray(numberOfUsers) { 1 }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        var all = 0

        events
            .sortedWith(compareBy<List<String>> { it[1].toInt() }.thenByDescending { it[0] })
            .forEach { (event, timestamp, id) ->
                when (event) {
                    "MESSAGE" -> {
                        while (pq.isNotEmpty() && pq.peek().first <= timestamp.toInt())
                            userStatus[pq.poll().second]++
                        when (id) {
                            "ALL" -> all++
                            "HERE" ->
                                for (i in userStatus.indices)
                                    if (userStatus[i] == 1)
                                        ans[i]++
                            else ->
                                for (userId in id.split(" ").map { it.substring(2).toInt() })
                                    ans[userId]++
                        }
                    }
                    else -> {
                        pq.offer(Pair(timestamp.toInt() + 60, id.toInt()))
                        userStatus[id.toInt()]--
                    }
                }
            }

        // Add "ALL" mentions
        for (i in userStatus.indices)
            ans[i] += all
        return ans.toList()
    }
}

fun main() {
    println(Solution3433().countMentions(3, listOf(
        listOf("MESSAGE","2","HERE"),
        listOf("OFFLINE","2","1"),
        listOf("OFFLINE","1","0"),
        listOf("MESSAGE","61","HERE")
    )))
}
