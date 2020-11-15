package com.ypwang.easy

class OrderedStream(val n: Int) {
    private val cache = Array<String?>(n){ null }
    private var idx = 0

    fun insert(id: Int, value: String): List<String> {
        cache[id-1] = value
        val rst = mutableListOf<String>()
        if (id-1 == idx) {
            while (idx < n && cache[idx] != null) {
                rst.add(cache[idx]!!)
                idx++
            }
        }

        return rst
    }
}