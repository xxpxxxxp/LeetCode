package com.ypwang.easy

class Solution3842 {
    fun toggleLightBulbs(bulbs: List<Int>): List<Int> =
        bulbs.groupBy { it }.filter { it.value.size % 2 == 1 }.keys.toList().sorted()
}
