package com.ypwang.medium

import java.util.*

class TweetCounts {
    private val cache = mutableMapOf<String, TreeMap<Int, Int>>()

    fun recordTweet(tweetName: String, time: Int) {
        val entry = cache.getOrPut(tweetName){ TreeMap() }
        entry[time] = entry.getOrDefault(time, 0) + 1
    }

    fun getTweetCountsPerFrequency(freq: String, tweetName: String, startTime: Int, endTime: Int): List<Int> {
        if (tweetName !in cache) return listOf()
        val entry = cache[tweetName]!!

        val interval = when (freq) {
            "minute" -> 60
            "hour" -> 3600
            else -> 86400
        }

        val rst = IntArray((endTime - startTime) / interval + 1)

        for ((t, c) in entry.subMap(startTime, endTime + 1)) {
            rst[(t - startTime) / interval] += c
        }

        return rst.toList()
    }
}

fun main() {
    val t = TweetCounts()
    t.recordTweet("a", 0)
    t.recordTweet("a", 60)
    t.recordTweet("a", 10)
    t.getTweetCountsPerFrequency("minute", "a", 0, 59)
    t.getTweetCountsPerFrequency("minute", "a", 0, 60)
    t.recordTweet("a", 120)
    t.getTweetCountsPerFrequency("hour", "a", 0, 210)
}