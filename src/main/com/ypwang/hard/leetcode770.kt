package com.ypwang.hard

import java.lang.StringBuilder
import java.util.*

class Solution770 {
    data class Element(val coefficient: Int = 1, val vars: List<String> = listOf()) {
        companion object {
            fun reduce(parts: List<Element>): List<Element> =
                parts.filter { it.coefficient != 0 }.groupBy { it.order() }.map { Element(it.value.sumBy { e -> e.coefficient }, it.value.first().vars) }.filter { it.coefficient != 0 }
        }

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

        fun order(): String = vars.groupBy { it }.mapValues { it.value.size }.toList().sortedBy { it.first }.joinToString { "${it.first}${it.second}" }
    }

    interface Component {
        fun output(): List<Element>
    }

    data class NumberComponent(val num: Int): Component {
        override fun output(): List<Element> = Element.reduce(listOf(Element(num)))
    }

    data class VariableComponent(val `var`: String): Component {
        override fun output(): List<Element> = listOf(Element(vars = listOf(`var`)))
    }

    data class MultipliedComponent(val sub: List<Component>): Component {
        companion object {
            fun reduce(parts: List<Component>): List<Element> {
                if (parts.size == 1) return parts.flatMap { it.output() }
                val left = reduce(parts.drop(1))
                return Element.reduce(parts.first().output().flatMap { e ->
                    left.map { e.merge(it) }
                })
            }
        }

        override fun output(): List<Element> = reduce(sub)
    }

    data class AddedComponent(val sub: List<Component>): Component {
        override fun output(): List<Element> = Element.reduce(sub.flatMap { it.output() })
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

    private fun readMultiplied(q: Queue<Char>, positive: Boolean = true): Component {
        val components = mutableListOf<Component>()
        if (!positive) components.add(NumberComponent(-1))
        while (q.peek() !in setOf(')', '+', '-')) {
            val cur = q.peek()
            when {
                cur == '*' -> q.poll()
                cur == '(' -> components.add(readAdded(q))
                cur.isDigit() -> components.add(NumberComponent(readInt(q)))
                cur.isLetter() -> components.add(VariableComponent(readVar(q)))
            }
        }

        return if (components.size == 1) components.single() else MultipliedComponent(components)
    }

    // 递归下降法
    private fun readAdded(q: Queue<Char>): Component {
        assert(q.poll() == '(')
        val components = mutableListOf<Component>()
        var p = true
        while (q.peek() != ')') {
            when (q.peek()) {
                '+' -> {
                    q.poll()
                    p = true
                }
                '-' -> {
                    q.poll()
                    p = false
                }
                else -> components.add(readMultiplied(q, p))
            }
        }
        assert(q.poll() == ')')
        return if (components.size == 1) components.single() else AddedComponent(components)
    }

    fun basicCalculatorIV(expression: String, evalvars: Array<String>, evalints: IntArray): List<String> {
        val eval = evalvars.zip(evalints.toList()).toMap()
        return readAdded(LinkedList("(${expression.filter { it != ' ' }})".toList()))
//                .apply {
//                    println(this)
//                }
                .output().map { it.calc(eval) }.let { Element.reduce(it) }.map { it.coefficient to it.vars.sorted() }
                .sortedWith(Comparator {
                    p1, p2 -> if (p1.second.size != p2.second.size) p2.second.size - p1.second.size
                    else p1.second.joinToString("_").compareTo(p2.second.joinToString("_"))
                }).map { "${it.first}${ if (it.second.isNotEmpty()) "*" else "" }${it.second.joinToString("*")}" }
    }
}

fun main() {
    println(Solution770().basicCalculatorIV("a + b", arrayOf("a", "b"), intArrayOf(99, -99)))
    println(Solution770().basicCalculatorIV("(a + b) * (a - b) + (b * b) - (2 * a) * (4 * a)", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("a * b - b * a", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("e + 8 - a + 5", arrayOf("e"), intArrayOf(1)))
    println(Solution770().basicCalculatorIV("e - 8 + temperature - pressure", arrayOf("e", "temperature"), intArrayOf(1, 12)))
    println(Solution770().basicCalculatorIV("(e + 8) * (e - 8)", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("7 - 7", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("a * b * c + b * a * c * 4", arrayOf(), intArrayOf()))
    println(Solution770().basicCalculatorIV("((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))", arrayOf(), intArrayOf()))
}