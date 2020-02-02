package com.ypwang.medium

class Solution1333 {
    fun filterRestaurants(restaurants: Array<IntArray>, veganFriendly: Int, maxPrice: Int, maxDistance: Int): List<Int>
            = restaurants.filter { it[2] >= veganFriendly && it[3] <= maxPrice && it[4] <= maxDistance }.sortedWith(Comparator{ a1, a2 -> if (a1[1] != a2[1]) a2[1].compareTo(a1[1]) else a2[0].compareTo(a1[0]) }).map { it[0] }
}