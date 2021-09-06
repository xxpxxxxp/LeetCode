package com.ypwang.medium

class LockingTree(private val parent: IntArray) {

    // sub node lock: num, user
    private val nodes = Array(parent.size) { mutableMapOf<Int, Int>() }

    fun lock(num: Int, user: Int): Boolean {
        if (num in nodes[num])
            // already locked
            return false

        var n = num
        while (n != -1) {
            nodes[n][num] = user
            n = parent[n]
        }

        return true
    }

    fun unlock(num: Int, user: Int): Boolean {
        if (nodes[num][num] != user)
            // unlocked | locked by others
            return false

        var n = num
        while (n != -1) {
            nodes[n].remove(num)
            n = parent[n]
        }

        return true
    }

    fun upgrade(num: Int, user: Int): Boolean {
        // check conditions
        // cur node not locked by anyone && at least 1 sub node locked
        var cond = num !in nodes[num] && nodes[num].isNotEmpty()
        if (!cond)
            return cond
        var n = parent[num]
        while (n != -1) {
            // ancestors not locked
            cond = cond && n !in nodes[n]
            n = parent[n]
            if (!cond)
                return cond
        }

        // perform operations
        // unlock all subs
        for ((n, u) in HashMap(nodes[num]))
            unlock(n, u)

        lock(num, user)
        return true
    }
}

fun main() {
    val tree = LockingTree(intArrayOf(-1,0,0,1,1,2,2))
    println(tree.lock(2,2))
    println(tree.unlock(2,3))
    println(tree.unlock(2,2))
    println(tree.lock(4,5))
    println(tree.upgrade(0,1))
    println(tree.lock(0,1))
}