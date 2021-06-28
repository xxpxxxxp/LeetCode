package com.ypwang.hard

import java.util.*

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {
    private val comparator = compareBy<Triple<Int, Int, Int>> { it.first }
        .thenBy { it.second }
        .thenBy { it.third }

    // price, shop, movie
    private val unrented = mutableMapOf<Int, TreeSet<Triple<Int, Int, Int>>>()
    private val prices = mutableMapOf<Pair<Int, Int>, Int>()
    private val rented = TreeSet(comparator)

    init {
        for ((shop, movie, price) in entries) {
            unrented.getOrPut(movie) { TreeSet(comparator) }.add(Triple(price, shop, movie))
            prices[Pair(shop, movie)] = price
        }
    }

    fun search(movie: Int): List<Int> =
        unrented[movie]?.take(5)?.map { it.second } ?: listOf()

    fun rent(shop: Int, movie: Int) {
        val t = Triple(prices[Pair(shop, movie)]!!, shop, movie)
        unrented[movie]!!.remove(t)
        rented.add(t)
    }

    fun drop(shop: Int, movie: Int) {
        val t = Triple(prices[Pair(shop, movie)]!!, shop, movie)
        unrented[movie]!!.add(t)
        rented.remove(t)
    }

    fun report(): List<List<Int>> =
        rented.take(5).map { listOf(it.second, it.third) }
}
