package com.ypwang.medium

class SubrectangleQueries(rectangle: Array<IntArray>) {
    private val ref = rectangle

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (row in row1..row2) {
            for (col in col1..col2)
                ref[row][col] = newValue
        }
    }

    fun getValue(row: Int, col: Int): Int = ref[row][col]
}
