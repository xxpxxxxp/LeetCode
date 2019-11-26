package com.ypwang.hard

import java.lang.StringBuilder
import java.util.*

class Solution770 {
    interface Component {
        fun output(): List<Element>
    }

    data class NumberComponent(val num: Int): Component {
        override fun output(): List<Element> = listOf(Element(num))
    }

    data class MultipliedComponent(val sub: List<Component>): Component {
        companion object {
            fun reduce(parts: List<Component>): List<Element> {
                if (parts.size == 1) return parts.flatMap { it.output() }
                val left = reduce(parts.drop(1))
                return parts.first().output().flatMap { e ->
                    left.map { e.merge(it) }
                }
            }
        }

        override fun output(): List<Element> = reduce(sub)
    }

    data class AddedComponent(val sub: List<Component>): Component {
        override fun output(): List<Element> = sub.flatMap { it.output() }
    }

    data class Element(val coefficient: Int = 1, val vars: List<String> = listOf()): Component {
        fun merge(that: Element): Element = Element(this.coefficient * that.coefficient, this.vars + that.vars)

        fun calc(eval: Map<String, Int>): Element {
            if (this.vars.isEmpty()) return this
            var coefficient = this.coefficient
            val vars = mutableListOf<String>()
            for (v in this.vars) {
                if (v in eval) coefficient *= eval[v]!!
                else vars.add(v)
            }

            return if (vars.size == this.vars.size) this else Element(coefficient, vars)
        }
        override fun output(): List<Element> = listOf(this)
    }

    private fun readInt(q: Queue<Char>): Int {
        var rst = 0
        while (q.isNotEmpty() && q.peek().isDigit()) {
            rst = rst * 10 + (q.poll() - '0')
        }
        return rst
    }

    private fun readVar(q: Queue<Char>): String {
        val sb = StringBuilder()
        while (q.isNotEmpty() && q.peek().isLetter()) {
            sb.append(q.poll())
        }
        return sb.toString()
    }

    // 递归下降法
    private fun parseComposed(q: Queue<Char>): Component {
        assert(q.poll() == '(')
        val components = mutableListOf<Component>()
        val vars = mutableListOf<Component>()
        var coefficient = 1
        while (q.peek() != ')') {
            val cur = q.peek()
            when {
                cur.isDigit() -> vars.add(NumberComponent(coefficient * readInt(q)))
                cur.isLetter() -> vars.add(Element(coefficient, listOf(readVar(q))))
                cur in setOf('+', '-') -> {
                    q.poll()
                    components.add(if (vars.size == 1) vars.first() else MultipliedComponent(vars.toList()))
                    vars.clear()
                    coefficient = if (cur == '+') 1 else -1
                }
                cur == '*' -> {
                    q.poll()
                    coefficient = 1
                }
                cur == '(' -> {
                    val c = parseComposed(q)
                    if (coefficient == 1) vars.add(c)
                    else vars.add(MultipliedComponent(listOf(NumberComponent(-1), c)))
                }
            }
        }
        assert(q.poll() == ')')
        components.add(if (vars.size == 1) vars.first() else MultipliedComponent(vars))
        return if (components.size == 1) components.first() else AddedComponent(components)
    }

    fun basicCalculatorIV(expression: String, evalvars: Array<String>, evalints: IntArray): List<String> {
        val eval = evalvars.zip(evalints.toList()).toMap()
        return parseComposed(LinkedList("(${expression.filter { it != ' ' }})".toList()))
//                .apply {
//                    println(this)
//                }
                .output().map { it.calc(eval) }
                .groupBy { it.vars.sorted() }.mapValues { it.value.sumBy { e -> e.coefficient } }.toList().sortedWith(kotlin.Comparator {
                    p1, p2 -> if (p1.first.size != p2.first.size) p2.first.size - p1.first.size
                    else p1.first.joinToString("").compareTo(p2.first.joinToString(""))}).map {
                    when {
                        it.second == 0 -> ""
                        it.first.isEmpty() -> it.second.toString()
                        else -> "${it.second}*${it.first.joinToString("*")}"
                    }
                }.filter { it.isNotEmpty() }
    }
}

fun main() {
    println(Solution770().basicCalculatorIV("(a + b) * (a - b) + (b * b) - (2 * a) * (4 * a)", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("a * b - b * a", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("e + 8 - a + 5", arrayOf("e"), intArrayOf(1)))
    println(Solution770().basicCalculatorIV("e - 8 + temperature - pressure", arrayOf("e", "temperature"), intArrayOf(1, 12)))
    println(Solution770().basicCalculatorIV("(e + 8) * (e - 8)", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("7 - 7", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("a * b * c + b * a * c * 4", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))", arrayOf(), intArrayOf()))
}