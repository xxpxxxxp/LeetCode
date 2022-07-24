package com.ypwang.medium

class NumberContainers {
    // index to number
    val lookup = mutableMapOf<Int, Int>()
    // number to indexes
    val list = mutableMapOf<Int, MutableList<Int>>()

    fun change(index: Int, number: Int) {
        if (index in lookup) {
            val nb = lookup[index]
            val i = list[nb]!!
            i.removeAt(i.binarySearch(index))
            if (i.isEmpty())
                list.remove(nb)
        }

        lookup[index] = number
        val ls = list.getOrPut(number) { mutableListOf() }
        ls.add(-ls.binarySearch(index)-1, index)
    }

    fun find(number: Int): Int {
        return list[number]?.first() ?: -1
    }
}

fun main() {
    val n = NumberContainers()
    n.find(10)
    n.change(2, 10)
    n.change(1, 10)
    n.change(3, 10)
    n.change(5, 10)
    n.find(10)
    n.change(1, 20)
    n.find(10)
}