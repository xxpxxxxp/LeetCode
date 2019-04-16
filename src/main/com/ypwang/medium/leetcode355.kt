package com.ypwang.medium

import java.util.*

class Twitter() {
    /** Initialize your data structure here. */
    val follow = mutableMapOf<Int, MutableSet<Int>>()
    val twitter = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    var time = 0

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        if (userId !in twitter) twitter[userId] = mutableListOf()
        val t = twitter[userId]!!
        if (t.size == 10) t.dropLast(1)
        t.add(0, time++ to tweetId)
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {
        var t = twitter.getOrDefault(userId, mutableListOf())
        val users = follow.getOrDefault(userId, mutableSetOf()).filter { it in twitter }.map { twitter[it]!! }

        for (user in users) {
            val next = mutableListOf<Pair<Int, Int>>()
            val f = LinkedList(t)
            val s = LinkedList(user)

            while (next.size < 10 && f.isNotEmpty() && s.isNotEmpty()) {
                val ff = f.peek()
                val ss = s.peek()

                if (ff.first > ss.first) {
                    next.add(f.pop())
                } else {
                    next.add(s.pop())
                }
            }

            while (next.size < 10 && f.isNotEmpty()) {
                next.add(f.pop())
            }

            while (next.size < 10 && s.isNotEmpty()) {
                next.add(s.pop())
            }

            t = next
        }

        return t.take(10).map { it.second }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        if (followerId == followeeId) return
        if (followerId !in follow) follow[followerId] = mutableSetOf()
        follow[followerId]!!.add(followeeId)
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        if (followerId == followeeId) return
        if (followerId in follow)
            follow[followerId]!!.remove(followeeId)
    }
}

fun main() {
    val t = Twitter()
    println(t.postTweet(1, 5))
    println(t.getNewsFeed(1))
    println(t.follow(1, 2))
    println(t.postTweet(2, 6))
    println(t.getNewsFeed(1))
    println(t.unfollow(1, 2))
    println(t.getNewsFeed(1))
}