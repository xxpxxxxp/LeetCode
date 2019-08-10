package com.ypwang.medium

class SnapshotArray(length: Int) {
    private class Store(val snap: Int, var `val`: Int)

    private var snap = 0
    private val store = Array(length){ ArrayList<Store>() }

    fun set(index: Int, `val`: Int) {
        val l = store[index]
        if (l.isNotEmpty() && l.last().snap == snap) l.last().`val` = `val`
        else l.add(Store(snap, `val`))
    }

    fun snap(): Int {
        return snap++
    }

    fun get(index: Int, snap_id: Int): Int {
        val l = store[index]
        val id = l.binarySearch { it.snap - snap_id }.let { if (it < 0) -it-2 else it }
        if (id < 0 || id >= l.size) return 0
        return l[id].`val`
    }
}

fun main() {
    val snap = SnapshotArray(1)
    println(snap.snap())
    println(snap.snap())
    snap.set(0,4)
    println(snap.snap())
    println(snap.get(0,1))
    snap.set(0,12)
    println(snap.get(0,1))
    println(snap.snap())
    println(snap.get(0,3))
}