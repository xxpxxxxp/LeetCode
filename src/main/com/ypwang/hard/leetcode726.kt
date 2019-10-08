package com.ypwang.hard

import java.lang.StringBuilder
import java.util.*

class Solution726 {
    interface Formula {
        fun yield(): Map<String, Int>
    }

    data class SingleFormula(val element: String, val recurrence: Int): Formula {
        override fun yield(): Map<String, Int> {
            return mapOf(element to recurrence)
        }
    }

    data class CombinedFormula(val formulas: List<Formula>, val recurrence: Int): Formula {
        override fun yield(): Map<String, Int> =
            formulas.map { it.yield() }.fold(mutableMapOf<String, Int>()) { R, cur ->
                cur.forEach { R[it.key] = if (it.key in R) R[it.key]!! + it.value else it.value }
                R
            }.map { it.key to recurrence * it.value }.toMap()
    }

    private fun readSymbol(formula: Queue<Char>): String {
        val sb = StringBuilder()
        assert(formula.peek().isUpperCase())
        sb.append(formula.poll())
        while (formula.peek().isLowerCase()) {
            sb.append(formula.poll())
        }

        return sb.toString()
    }

    private fun readInt(formula: Queue<Char>): Int {
        if (formula.isEmpty() || !formula.peek().isDigit()) return 1
        var r = 0
        while (formula.peek().isDigit()) {
            r = r * 10 + (formula.poll() - '0')
        }
        return r
    }

    private fun parse(formula: Queue<Char>): Formula {
        assert(formula.poll() == '(')
        val rst = mutableListOf<Formula>()
        while (formula.peek() != ')') {
            when (formula.peek()) {
                '(' -> rst.add(parse(formula))
                else -> {
                    val element = readSymbol(formula)
                    val recurrence = readInt(formula)
                    rst.add(SingleFormula(element, recurrence))
                }
            }
        }
        assert(formula.poll() == ')')
        val recurrence = readInt(formula)

        return if (rst.size == 1 && recurrence == 1) rst.first() else CombinedFormula(rst, recurrence)
    }

    fun countOfAtoms(formula: String): String {
        return parse(LinkedList("($formula)".toList())).yield().toList().sortedBy { it.first }.joinToString("") { "${it.first}${if (it.second > 1) it.second else ""}" }
    }
}

fun main() {
    println(Solution726().countOfAtoms("H2O"))
    println(Solution726().countOfAtoms("Mg(OH)2"))
    println(Solution726().countOfAtoms("K4(ON(SO3)2)2"))
    println(Solution726().countOfAtoms("((HHe28Be26He)9)34"))
}