package com.ypwang.medium

import java.util.*

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    class Food(val name: String, val cuisine: String, var rating: Int)
    val x = mutableMapOf<String, PriorityQueue<Food>>()
    val menu = mutableMapOf<String, Food>()

    init {
        for (i in foods.indices) {
            val curr = Food(foods[i], cuisines[i], ratings[i])
            x.getOrPut(cuisines[i]) {
                PriorityQueue<Food> { a, b -> if (b.rating == a.rating) a.name.compareTo(b.name) else b.rating.compareTo(a.rating) }
            }.add(curr)
            menu[foods[i]] = curr
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val curr = menu[food]
        val pq = x[curr!!.cuisine]!!
        pq.remove(curr)
        curr.rating = newRating
        pq.add(curr)
    }

    fun highestRated(cuisine: String): String {
        return x[cuisine]!!.peek()!!.name
    }
}