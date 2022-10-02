package com.ypwang.medium

class LUPrefix(n: Int) {
    private val set = mutableSetOf<Int>()
    private var pre = 0

    fun upload(video: Int) {
        set.add(video)

        while (pre + 1 in set)
            pre++
    }

    fun longest(): Int = pre
}
