package com.ypwang.easy

class Solution70 {
    val s = mutableMapOf<Int, Int>()
    fun climbStairs(n: Int): Int {
        if (n == 1 || n == 2) {
            return n
        }

        val m1 = if (s.containsKey(n-1)) s[n-1]!! else { s[n-1] = climbStairs(n-1); s[n-1]!! }
        val m2 = if (s.containsKey(n-2)) s[n-2]!! else { s[n-2] = climbStairs(n-2); s[n-2]!! }
        return m1 + m2
    }
}

class MyHashMap {

    /** Initialize your data structure here.  */
    private inner class Node(var key: Int, var value: Int)
    private val list = mutableListOf<Node>()

    /** value will always be non-negative.  */
    fun put(key: Int, value: Int) {
        for (node in list) {
            if (node.key == key) {
                node.value = value
                return
            }
        }
        list.add(Node(key, value))
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key  */
    fun get(key: Int): Int {
        return list.firstOrNull { it.key == key }?.value?:-1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key  */
    fun remove(key: Int) {
        val iter = list.iterator()
        while (iter.hasNext()) {
            if (iter.next().key == key) iter.remove()
        }
    }
}