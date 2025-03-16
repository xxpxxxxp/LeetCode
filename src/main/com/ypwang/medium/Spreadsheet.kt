package com.ypwang.medium

class Spreadsheet(rows: Int) {
    private val cols = Array(26) { mutableMapOf<Int, Int>() }

    private fun helper(cell: String): Pair<Char, Int> =
        cell.first() to cell.drop(1).toInt()

    fun setCell(cell: String, value: Int) {
        val (c, r) = helper(cell)
        cols[c-'A'][r] = value
    }

    fun resetCell(cell: String) {
        val (c, r) = helper(cell)
        cols[c-'A'].remove(r)
    }

    private fun getCellOrValue(cell: String): Int {
        if (cell.first().isDigit())
            return cell.toInt()

        val (c, r) = helper(cell)
        return cols[c-'A'].getOrDefault(r, 0)
    }

    fun getValue(formula: String): Int {
        assert(formula.first() == '=')
        val (p1, p2) = formula.drop(1).split('+')
        return getCellOrValue(p1) + getCellOrValue(p2)
    }
}
