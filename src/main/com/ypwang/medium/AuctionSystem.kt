package com.ypwang.medium

import java.util.*

class AuctionSystem {
    private val mp = mutableMapOf<Int, MutableMap<Int, Int>>()
    private val ts = mutableMapOf<Int, TreeSet<Pair<Int, Int>>>()

    fun addBid(userId: Int, itemId: Int, bidAmount: Int) {
        val b = mp.getOrPut(itemId) { mutableMapOf() }
        val t = ts.getOrPut(itemId) { TreeSet(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }) }
        if (userId in b)
            t.remove(b[userId] to userId)
        b[userId] = bidAmount
        t.add(bidAmount to userId)
    }

    fun updateBid(userId: Int, itemId: Int, newAmount: Int) = addBid(userId, itemId, newAmount)

    fun removeBid(userId: Int, itemId: Int) {
        val bid = mp[itemId]!!.remove(userId)
        ts[itemId]!!.remove(bid to userId)
    }

    fun getHighestBidder(itemId: Int): Int {
        val t = ts[itemId]
        return if (t.isNullOrEmpty()) -1 else t.last().second
    }
}
