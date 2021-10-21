package com.ypwang.medium

class Solution1981 {
    fun minimizeTheDifference(mat: Array<IntArray>, target: Int): Int =
        mat.fold(setOf(0)) { arr, set ->
            val row = arr.toSet()
            val add = row.flatMap { r -> set.map { c -> c + r } }.toSet()
            val min = add.map { Math.abs(it - target) }.minOrNull()!!

            add.filter { it <= min + target }.toSet()
        }.map { Math.abs(it - target) }.minOrNull()!!
}