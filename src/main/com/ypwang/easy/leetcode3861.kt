package com.ypwang.easy

class Solution3861 {
    fun minimumIndex(capacity: IntArray, itemSize: Int): Int =
        capacity.withIndex()
            .filter { it.value >= itemSize }
            .minWithOrNull(compareBy<IndexedValue<Int>> { it.value }.thenBy { it.index })
            ?.index ?: -1
}
