package com.ypwang.easy

class Solution2418 {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> =
        names.zip(heights.toList()).sortedByDescending { it.second }.map { it.first }.toTypedArray()
}