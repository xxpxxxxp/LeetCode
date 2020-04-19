package com.ypwang.medium

class Solution1418 {
    fun displayTable(orders: List<List<String>>): List<List<String>> {
        val dishs = mutableSetOf<String>()
        val tables = mutableMapOf<String, MutableMap<String, Int>>()

        for ((_, table, dish) in orders) {
            dishs.add(dish)
            val m = tables.getOrPut(table){ mutableMapOf() }
            m[dish] = m.getOrDefault(dish, 0) + 1
        }

        val orderedDishs = dishs.toList().sorted()
        val rst = mutableListOf(listOf("Table") + orderedDishs)
        rst.addAll(tables.toList().sortedBy { it.first.toInt() }.map { (i, map) ->
            listOf(i) + orderedDishs.map { map.getOrDefault(it, 0).toString() }
        })

        return rst
    }
}

fun main() {
    println(Solution1418().displayTable(listOf(
            listOf("David","3","Ceviche"), listOf("Corina","10","Beef Burrito"),
            listOf("David","3","Fried Chicken"), listOf("Carla","5","Water"),
            listOf("Carla","5","Ceviche"),listOf("Rous","3","Ceviche")
    )))
}